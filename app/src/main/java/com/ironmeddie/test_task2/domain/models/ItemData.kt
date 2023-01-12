package com.ironmeddie.test_task2.domain.models


data class ItemData(
    val id: String,
    val picture: String,
    val morePhoto: List<String>,
    val nalichie: Nalichie,
    val name: String,
    val rating: Double,
    val favorite : Boolean,
    val extendedPrice: List<ExtendedPrice>
    )
