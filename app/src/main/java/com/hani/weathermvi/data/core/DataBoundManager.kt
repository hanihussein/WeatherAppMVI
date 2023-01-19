package com.hani.weathermvi.data.core

import androidx.annotation.WorkerThread
import com.hani.weathermvi.domain.core.DataState
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

abstract class DataBoundManager<ResponseModel, DomainModel>(var context: CoroutineContext) {

    fun asFlow() = flow {

        emit(DataState.LOADING())
        try {
            emit(handleRemoteSuccessResponse(fetchFromNetwork()))

        } catch (e: Throwable) {
            emit(handleDataError(e))
        }
    }.flowOn(context)

    @WorkerThread
    protected abstract suspend fun fetchFromNetwork(): ResponseModel

    protected abstract suspend fun handleRemoteSuccessResponse(response: ResponseModel): DataState<DomainModel>

    protected abstract suspend fun handleDataError(e: Throwable): DataState<DomainModel>

    //TODO Can Add handle local/Cache data later if needed
}