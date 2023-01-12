package com.ironmeddie.test_task2.domain.use_cases

import com.ironmeddie.test_task2.domain.repository.ProductsRepository
import javax.inject.Inject

class GetDataUseCase @Inject constructor(private val repository: ProductsRepository){
     operator fun invoke() = repository.getData()
}