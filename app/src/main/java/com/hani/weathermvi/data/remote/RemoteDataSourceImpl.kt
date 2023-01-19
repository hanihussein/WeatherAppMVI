package com.hani.weathermvi.data.remote

import com.hani.weathermvi.data.model.LocationWeatherResponse
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val remoteServiceProvider: RemoteServiceProvider) :
    RemoteDataSource {
    override suspend fun getWeatherForecast(lat: Double, lon: Double): LocationWeatherResponse {
        return remoteServiceProvider.getWeatherForecast(lat, lon)
    }
}
