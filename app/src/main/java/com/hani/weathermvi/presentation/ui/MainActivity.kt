package com.hani.weathermvi.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.google.android.material.snackbar.Snackbar
import com.hani.weathermvi.R
import com.hani.weathermvi.databinding.ActivityMainBinding
import com.hani.weathermvi.domain.core.DataState
import com.hani.weathermvi.presentation.ui.state.MainAction
import com.hani.weathermvi.util.WeatherLocationConsts
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewState = viewModel.viewState
        binding.lifecycleOwner = this
    }


    override fun onResume() {
        super.onResume()
        initCallbacks()
        dispatchActions()
    }

    private fun dispatchActions() {
        viewModel.dispatchIntent(
            MainAction.GetWeatherForecastAction(
                WeatherLocationConsts.GOTHENBURG_LAT,
                WeatherLocationConsts.GOTHENBURG_LON
            )
        ) // WeatherLocationConsts attributes just for demo , can be replaced by real location
    }

    private fun initCallbacks() {
        viewModel.let { vm ->
            vm.dataState.observe(this) {
                it.getContentIfNotHandled()?.let { dataStatus ->

                    showLoadingView(dataStatus.loading)

                    when (dataStatus) {
                        is DataState.ERROR -> {
                            dataStatus.stateMessage?.let { it1 ->
                                Snackbar
                                    .make(binding.root, it1, Snackbar.LENGTH_INDEFINITE)
                                    .setAction(R.string.retry) {
                                        dispatchActions()
                                    }.show()
                            }
                        }

                        is DataState.SUCCESS -> {
                            showLoadingView(false)
                            dataStatus.data?.let { it1 -> viewModel.updateViewState(it1) }
                            binding.mainView.visibility = View.VISIBLE
                        }
                        else -> {}
                    }
                }
            }
        }
    }


    private fun showLoadingView(isVisible: Boolean) {
        if (isVisible)
            binding.loadingView.visibility = View.VISIBLE
        else
            binding.loadingView.visibility = View.GONE
    }

    private fun showMessage(message: String) {
        Snackbar
            .make(binding.root, message, Snackbar.LENGTH_INDEFINITE)
            .setAction(R.string.retry) {
                dispatchActions()
            }.show()
    }

}