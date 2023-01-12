package com.ironmeddie.test_task2.domain.repository

import com.ironmeddie.test_task2.common.utils.DataResource
import com.ironmeddie.test_task2.data.dto.ProductsDto
import com.ironmeddie.test_task2.domain.models.Products
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
     fun getData() : Flow<DataResource<Products>>
}