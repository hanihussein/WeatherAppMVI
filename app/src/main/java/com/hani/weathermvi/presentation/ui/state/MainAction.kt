package com.hani.weathermvi.presentation.ui.state

import com.hani.weathermvi.presentation.core.ViewAction

sealed class MainAction : ViewAction {
    data class GetWeatherForecastAction(val lat: Double, val lon: Double) : MainAction()
}