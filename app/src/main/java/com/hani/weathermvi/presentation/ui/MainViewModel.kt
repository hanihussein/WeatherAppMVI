package com.hani.weathermvi.presentation.ui

import com.hani.weathermvi.domain.core.DataState
import com.hani.weathermvi.domain.model.WeatherForecastModel
import com.hani.weathermvi.domain.usecase.GetWeatherForecastUseCase
import com.hani.weathermvi.presentation.core.BaseViewModel
import com.hani.weathermvi.presentation.ui.state.MainAction
import com.hani.weathermvi.presentation.ui.state.MainStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getWeatherForecastUseCase: GetWeatherForecastUseCase,
) : BaseViewModel<MainAction, MainStatus>() {

    override fun handleAction(action: MainAction): Flow<DataState<out Any>> {
        return when (action) {
            is MainAction.GetWeatherForecastAction -> {
                getWeatherForecastUseCase.invoke(action.lat, action.lon)
            }
        }
    }

    override fun handleSuccessStatus(action: MainAction, data: Any?): DataState<MainStatus> {
        return when (action) {
            is MainAction.GetWeatherForecastAction -> {
                DataState.SUCCESS(MainStatus(weatherForecastModel = data as WeatherForecastModel))
            }
        }
    }
}

