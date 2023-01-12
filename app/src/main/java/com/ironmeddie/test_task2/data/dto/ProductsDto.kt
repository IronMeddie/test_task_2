package com.ironmeddie.test_task2.data.dto

import com.ironmeddie.test_task2.domain.models.Products

data class ProductsDto(
    val TOVARY: List<TOVARY>,
    val message: String,
    val status: String
){
    fun toProducts() : Products{
        return Products(
            tovary = TOVARY.map { it.toItemData() }
        )
    }
}