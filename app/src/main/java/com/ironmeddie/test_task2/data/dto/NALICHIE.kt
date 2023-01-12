package com.ironmeddie.test_task2.data.dto

import com.ironmeddie.test_task2.domain.models.Nalichie

data class NALICHIE(
    val CVET: String,
    val NAME: String,
    val X: String,
    val Y: String,
    val Z: String
){
    fun toNalichie(): Nalichie {
        return Nalichie(
            color = CVET,
            name = NAME,
            x = X,
            y = Y,
            z = Z
        )
    }

}