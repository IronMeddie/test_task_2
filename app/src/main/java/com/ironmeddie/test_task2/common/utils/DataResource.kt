package com.ironmeddie.test_task2.common.utils

import okhttp3.ResponseBody

sealed class DataResource<out T> {
    data class Success<out T>(val data: T) : DataResource<T>()
    data class Failure(
        val isNetworkError: Boolean,
        val errorCode: Int?,
        val errorBody: ResponseBody?,
        val otherMessage: String?
    ) : DataResource<Nothing>()

    object Loading : DataResource<Nothing>()
}


//sealed class Resource<T>(val data: T? = null, val message: String? = null){
//    class Succes<T>(data: T): Resource<T>(data)
//    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
//    class Loading<T>(data: T? = null) : Resource<T>(data)
//}
