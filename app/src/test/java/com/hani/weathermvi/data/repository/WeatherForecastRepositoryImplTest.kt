package com.hani.weathermvi.data.repository

import com.hani.weathermvi.TestMockData
import com.hani.weathermvi.TestHelper
import com.hani.weathermvi.data.core.DataErrorHandler
import com.hani.weathermvi.data.model.LocationWeatherResponse
import com.hani.weathermvi.data.remote.RemoteDataSource
import com.hani.weathermvi.domain.core.DataState
import com.hani.weathermvi.domain.model.WeatherForecastModel
import com.hani.weathermvi.domain.repository.WeatherForecastRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.spyk
import junit.framework.TestCase
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


internal class WeatherForecastRepositoryImplTest {

    private val remoteDataSource = spyk<RemoteDataSource>()
    private val dataErrorHandler = spyk<DataErrorHandler>()

    @Before
    fun setUp() = MockKAnnotations.init(this, relaxUnitFun = true)


    @Test
    fun `loadWeather - getResponse - Loading then Success `(): Unit =
        runBlocking {

            coEvery { remoteDataSource.getWeatherForecast(TestMockData.City_LAT, TestMockData.City_LON) } returns
                    TestHelper.convertJsonToModel(
                        TestHelper.loadJsonAsString(TestMockData.CITY_WEATHER_SUCCESS_SERVER_RESPONSE),
                        LocationWeatherResponse::class.java
                    )

            val repository: WeatherForecastRepository =
                WeatherForecastRepositoryImpl(remoteDataSource, dataErrorHandler)
            val results = repository.getWeatherForecast(TestMockData.City_LAT, TestMockData.City_LON).toList()
            TestCase.assertEquals(results[0] is DataState.LOADING<WeatherForecastModel>, true)
            TestCase.assertEquals(results[1] is DataState.SUCCESS<WeatherForecastModel>, true)
            TestCase.assertEquals(
                results[1].data, TestMockData.CITY_WEATHER_SUCCESS_WRAPPED_DOMAIN_RESPONSE
            )

            TestCase.assertEquals(results.size, 2)
        }


    @Test
    fun `loadAndroidArticle - getHttpException - Loading then Error `(): Unit =
        runBlocking {

            coEvery { remoteDataSource.getWeatherForecast(TestMockData.City_LAT, TestMockData.City_LON) } throws TestMockData.HTTP_EXCEPTION_MOCK
            coEvery { dataErrorHandler.getErrorMessage(TestMockData.HTTP_EXCEPTION_MOCK) } returns TestMockData.ERROR_MESSAGE_CONNECTIVITY_ISSE

            val repository: WeatherForecastRepository =
                WeatherForecastRepositoryImpl(remoteDataSource, dataErrorHandler)
            val results = repository.getWeatherForecast(TestMockData.City_LAT, TestMockData.City_LON).toList()
            TestCase.assertEquals(results[0] is DataState.LOADING<WeatherForecastModel>, true)
            TestCase.assertEquals(results[1] is DataState.ERROR<WeatherForecastModel>, true)
            TestCase.assertEquals(results[1].stateMessage, TestMockData.ERROR_MESSAGE_CONNECTIVITY_ISSE)

            TestCase.assertEquals(results.size, 2)
        }
}