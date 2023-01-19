package com.hani.weathermvi.data.core

import android.content.res.Resources
import com.hani.weathermvi.R
import kotlinx.coroutines.TimeoutCancellationException
import retrofit2.HttpException
import java.io.IOException

class DataErrorHandlerImpl(private val res: Resources) : DataErrorHandler {
    override fun getErrorMessage(throwable: Throwable): String {

        when (throwable) {

            is HttpException -> {
                return res.getString(R.string.error_connectivity_issue)
            }
            is IOException -> {
                return res.getString(R.string.error_connectivity_issue)
            }

            is TimeoutCancellationException -> {
                return res.getString(R.string.error_connectivity_issue)
            }

            else -> {
                return res.getString(R.string.error_generic)
            }
        }
    }
}