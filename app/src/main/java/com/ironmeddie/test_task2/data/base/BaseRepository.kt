package com.ironmeddie.test_task2.data.base

import com.ironmeddie.test_task2.common.utils.DataResource
import com.ironmeddie.test_task2.common.utils.UtilConstants.NO_INTERNET
import com.ironmeddie.test_task2.common.utils.UtilConstants.OTHER_ERROR
import com.ironmeddie.test_task2.common.utils.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

interface BaseRepository {
    suspend fun <T> safeApiCall(apiCall: suspend () -> T): DataResource<T> {
        return withContext(Dispatchers.IO) {
            try {
                DataResource.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is HttpException -> {
                        DataResource.Failure(false, throwable.code(), throwable.response()?.errorBody(), throwable.message)
                    }
                    else -> {
                        if (throwable.message == NO_INTERNET) {
                            log("throwable.message == NO_INTERNET")
                            DataResource.Failure(true, null, null, throwable.message)
                        } else DataResource.Failure(true, OTHER_ERROR, null, throwable.message) // CHANGE THIS TO FALSE
                    }
                }
            }
        }
    }
}


