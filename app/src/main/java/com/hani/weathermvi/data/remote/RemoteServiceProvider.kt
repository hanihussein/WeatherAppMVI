package com.hani.weathermvi.data.remote

import com.hani.weathermvi.BuildConfig
import com.hani.weathermvi.data.model.LocationWeatherResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RemoteServiceProvider {
    @Headers(
        "Content-Type: application/json",
        "User-Agent:${BuildConfig.APPLICATION_ID}"
    )
    @GET("complete")
    suspend fun getWeatherForecast(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): LocationWeatherResponse
}
