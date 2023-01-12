package com.ironmeddie.test_task2.data.repository

import com.ironmeddie.test_task2.common.utils.DataResource
import com.ironmeddie.test_task2.data.base.BaseRepository
import com.ironmeddie.test_task2.data.remote.ApiService
import com.ironmeddie.test_task2.domain.models.Products
import com.ironmeddie.test_task2.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(private val apiService: ApiService) : ProductsRepository,
    BaseRepository {
    override fun getData(): Flow<DataResource<Products>> = flow{
        val res  = safeApiCall { apiService.getData() }
        when (res){
            is DataResource.Success -> emit(DataResource.Success(res.data.toProducts()))
            is DataResource.Failure -> emit(res)
        }


    }
}