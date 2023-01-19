package com.hani.weathermvi.data.di

import android.content.Context
import com.hani.weathermvi.data.core.DataErrorHandler
import com.hani.weathermvi.data.core.DataErrorHandlerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HandlersModule {

    @Provides
    @Singleton
    fun providesDataErrorHandler(@ApplicationContext context: Context): DataErrorHandler = DataErrorHandlerImpl(context.resources)

}