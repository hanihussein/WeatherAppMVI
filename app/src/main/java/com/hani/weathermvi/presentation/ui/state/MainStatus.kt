package com.hani.weathermvi.presentation.ui.state

import com.hani.weathermvi.domain.model.WeatherForecastModel
import com.hani.weathermvi.presentation.core.ViewState

data class MainStatus(var weatherForecastModel: WeatherForecastModel) : ViewState