package com.ironmeddie.test_task2.domain.models

data class ExtendedPrice(
    val oldPrice: Int,
    val price: Int,
    val quantityFrom: Int,
    val quantityTo: Int
)