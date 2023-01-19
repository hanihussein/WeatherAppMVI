package com.hani.weathermvi.data.di

import com.hani.weathermvi.data.core.DataErrorHandler
import com.hani.weathermvi.data.remote.RemoteDataSource
import com.hani.weathermvi.domain.repository.WeatherForecastRepository
import com.hani.weathermvi.data.repository.WeatherForecastRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun providesTrueCallerRepository(remoteDataSource: RemoteDataSource, dataErrorHandler: DataErrorHandler): WeatherForecastRepository =
        WeatherForecastRepositoryImpl(remoteDataSource , dataErrorHandler)

}
