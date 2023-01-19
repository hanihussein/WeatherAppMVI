package com.hani.weathermvi

import com.hani.weathermvi.domain.model.DayForecastModel
import com.hani.weathermvi.domain.model.WeatherForecastModel
import okhttp3.MediaType
import okhttp3.ResponseBody
import retrofit2.HttpException
import retrofit2.Response


object TestMockData {

    const val TIMESTAMP_1 = "2021-01-28T11:55:21Z"
    const val CONVERTED_TIMESTAMP = "2021-01-28"

    const val City_LAT = 57.7089
    const val City_LON = 11.9746

    val CITY_WEATHER_SUCCESS_WRAPPED_DOMAIN_RESPONSE = WeatherForecastModel(currentDayForecast=DayForecastModel(date="2023-01-18", maxTemp=4.2f, minTemp=2.3f, speed=3.2f, symbol_code="partlycloudy_day"),
        upcomingDaysForecast= mutableListOf(DayForecastModel(date="2023-01-19", maxTemp=1.8f, minTemp=-0.2f, speed=2.2f, symbol_code="partlycloudy_day"), DayForecastModel(date="2023-01-20", maxTemp=1.9f, minTemp=0.3f, speed=1.9f, symbol_code="cloudy"), DayForecastModel(date="2023-01-21", maxTemp=1.0f, minTemp=-1.2f, speed=1.4f, symbol_code="partlycloudy_day"), DayForecastModel(date="2023-01-22", maxTemp=0.8f, minTemp=-1.7f, speed=1.6f, symbol_code="cloudy"), DayForecastModel(date="2023-01-23", maxTemp=2.9f, minTemp=-0.6f, speed=1.9f, symbol_code="cloudy"), DayForecastModel(date="2023-01-24", maxTemp=4.3f, minTemp=2.4f, speed=4.6f, symbol_code="cloudy"), DayForecastModel(date="2023-01-25", maxTemp=6.3f, minTemp=5.2f, speed=5.1f, symbol_code="cloudy"), DayForecastModel(date="2023-01-26", maxTemp=5.4f, minTemp=1.5f, speed=2.8f, symbol_code="partlycloudy_day"), DayForecastModel(date="2023-01-27", maxTemp=4.1f, minTemp=-0.3f, speed=2.7f, symbol_code="partlycloudy_day"), DayForecastModel(date="2023-01-28", maxTemp=5.0f, minTemp=4.6f, speed=5.7f, symbol_code=null)))

    const val CITY_WEATHER_SUCCESS_SERVER_RESPONSE =  "WeatherServerResponse.json"

    const val ERROR_MESSAGE_CONNECTIVITY_ISSE ="Due to a network issue we cannot process your request at the moment. Check your connection and try again later"

    val HTTP_EXCEPTION_MOCK = HttpException(
        Response.error<ResponseBody>(
            500, ResponseBody.create(
                MediaType.parse("plain/text"), "some content"
            )
        )
    )

}