package com.hani.weathermvi.presentation.core

import androidx.lifecycle.LiveData
import com.hani.weathermvi.domain.core.DataState

interface IModel<STATE, ACTION> {
    val dataState: LiveData<Event<DataState<STATE>>>
    val viewState: LiveData<STATE>

    fun dispatchIntent(action: ACTION)
}