package com.hani.weathermvi.presentation.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hani.weathermvi.domain.core.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

abstract class BaseViewModel<ACTION : ViewAction, STATE : ViewState> :
    ViewModel(), IModel<STATE, ACTION> {

    private val flow = MutableSharedFlow<DataState<STATE>>(replay = 0)

    private val mDataState: MutableLiveData<Event<DataState<STATE>>> = MutableLiveData()
    override val dataState: LiveData<Event<DataState<STATE>>>
        get() = mDataState

    private val mViewState: MutableLiveData<STATE> = MutableLiveData()
    override val viewState: LiveData<STATE>
        get() = mViewState


    init {
        flow.onEach { dataStates ->
            mDataState.value = Event(dataStates)
        }.launchIn(viewModelScope)
    }


    final override fun dispatchIntent(action: ACTION) {
        handleAction(action).onEach { dataState ->
            when (dataState) {
                is DataState.LOADING -> {
                    flow.emit(handleLoadingStatus(action))
                }
                is DataState.ERROR -> {
                    flow.emit(handleErrorState(action, dataState.stateMessage))
                }
                is DataState.SUCCESS -> {
                    flow.emit(handleSuccessStatus(action, dataState.data))
                }
            }
        }.launchIn(viewModelScope)
    }

    open fun updateViewState(viewState: STATE) {
        mViewState.value = viewState
    }

    open fun handleErrorState(action: ACTION, message: String?) = DataState.ERROR<STATE>(stateMessage = message)

    open fun handleLoadingStatus(action: ACTION): DataState<STATE> = DataState.LOADING()

    abstract fun handleSuccessStatus(action: ACTION, data: Any?): DataState<STATE>

    abstract fun handleAction(action: ACTION): Flow<DataState<out Any>>


}