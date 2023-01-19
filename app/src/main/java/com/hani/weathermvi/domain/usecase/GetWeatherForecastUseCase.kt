package com.hani.weathermvi.domain.usecase

import com.hani.weathermvi.domain.core.DataState
import com.hani.weathermvi.domain.model.WeatherForecastModel
import com.hani.weathermvi.domain.repository.WeatherForecastRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeatherForecastUseCase @Inject constructor(private val repository: WeatherForecastRepository) {

    operator fun invoke(lat: Double, lon: Double): Flow<DataState<WeatherForecastModel>> {
        return repository.getWeatherForecast(lat, lon)
    }
}
