package com.hani.weathermvi.data.remote

import com.hani.weathermvi.data.model.LocationWeatherResponse

interface RemoteDataSource {
    suspend fun getWeatherForecast(lat: Double, lon: Double): LocationWeatherResponse
}
