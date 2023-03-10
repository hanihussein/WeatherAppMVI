package com.hani.weathermvi.domain.model


data class WeatherForecastModel(
     val currentDayForecast: DayForecastModel,
     val upcomingDaysForecast: MutableList<DayForecastModel>
)

data class DayForecastModel(
     val date: String,
     val maxTemp: Float,
     val minTemp: Float,
     val speed: Float,
     val symbol_code: String?
)