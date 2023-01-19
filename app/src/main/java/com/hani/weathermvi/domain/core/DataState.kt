package com.hani.weathermvi.domain.core

sealed class DataState<T>(
    var loading: Boolean,
    var data: T? = null,
    var stateMessage: String? = null,
) {
    class LOADING<T>(
        data: T? = null,
        isLoading: Boolean = true,
    ) : DataState<T>(
        loading = isLoading,
        data = data,
    )

    class SUCCESS<T>(
        data: T? = null,
        stateMessage: String? = null,
        val cached: Boolean = false,
    ) : DataState<T>(
        loading = false,
        data = data,
        stateMessage = stateMessage
    )

    class ERROR<T>(
        data: T? = null,
        stateMessage: String? = null,
    ) : DataState<T>(
        loading = false,
        data = data,
        stateMessage = stateMessage
    )
}
