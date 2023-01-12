package com.ironmeddie.test_task2.data.dto

import com.ironmeddie.test_task2.domain.models.ExtendedPrice

data class EXTENDEDPRICE(
    val OLD_PRICE: Int,
    val PRICE: Int,
    val QUANTITY_FROM: Int,
    val QUANTITY_TO: Int
){
   fun toExtendedPrice() : ExtendedPrice = ExtendedPrice(
       oldPrice = OLD_PRICE,
       price = PRICE,
       quantityFrom = QUANTITY_FROM,
       quantityTo = QUANTITY_TO
   )
}

