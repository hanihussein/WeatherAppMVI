package com.hani.weathermvi.domain.repository

import com.hani.weathermvi.domain.core.DataState
import com.hani.weathermvi.domain.model.WeatherForecastModel
import kotlinx.coroutines.flow.Flow

interface WeatherForecastRepository {
     fun getWeatherForecast(lat: Double, lon: Double): Flow<DataState<WeatherForecastModel>>
}
