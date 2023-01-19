package com.hani.weathermvi.data.repository

import com.hani.weathermvi.data.core.DataBoundManager
import com.hani.weathermvi.data.core.DataErrorHandler
import com.hani.weathermvi.data.model.LocationWeatherResponse
import com.hani.weathermvi.data.remote.RemoteDataSource
import com.hani.weathermvi.data.wrapper.toWeatherForecastModel
import com.hani.weathermvi.domain.core.DataState
import com.hani.weathermvi.domain.model.WeatherForecastModel
import com.hani.weathermvi.domain.repository.WeatherForecastRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherForecastRepositoryImpl @Inject constructor(
    private val remote: RemoteDataSource,
    private val dataErrorHandler: DataErrorHandler
) : WeatherForecastRepository {

    override fun getWeatherForecast(lat: Double, lon: Double): Flow<DataState<WeatherForecastModel>> {

        return object : DataBoundManager<LocationWeatherResponse, WeatherForecastModel>(Dispatchers.IO) {

            override suspend fun fetchFromNetwork(): LocationWeatherResponse {
                return remote.getWeatherForecast(lat, lon)
            }

            override suspend fun handleRemoteSuccessResponse(response: LocationWeatherResponse): DataState<WeatherForecastModel> {
                return DataState.SUCCESS(response.toWeatherForecastModel())
            }

            override suspend fun handleDataError(e: Throwable): DataState<WeatherForecastModel> {
                return DataState.ERROR(stateMessage = dataErrorHandler.getErrorMessage(e))
            }
        }.asFlow()
    }
}