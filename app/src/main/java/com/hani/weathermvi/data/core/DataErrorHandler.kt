package com.hani.weathermvi.data.core

interface DataErrorHandler {
 fun getErrorMessage(throwable: Throwable) :String
}