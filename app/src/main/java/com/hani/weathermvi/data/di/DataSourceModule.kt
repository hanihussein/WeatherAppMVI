package com.hani.weathermvi.data.di

import com.hani.weathermvi.data.remote.RemoteDataSource
import com.hani.weathermvi.data.remote.RemoteDataSourceImpl
import com.hani.weathermvi.data.remote.RemoteServiceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Singleton
    @Provides
    fun providesRemoteDataSource(remoteServiceProvider: RemoteServiceProvider): RemoteDataSource =
        RemoteDataSourceImpl(remoteServiceProvider)


    @Singleton
    @Provides
    fun providesRemoteServiceProvider(retrofit: Retrofit): RemoteServiceProvider =
        retrofit.create(RemoteServiceProvider::class.java)

}