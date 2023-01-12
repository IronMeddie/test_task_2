package com.ironmeddie.test_task2.data.dto

import com.ironmeddie.test_task2.domain.models.Tovary

data class TOVARY(
    val ID: Int,
    val NAME: String,
    val `data`: List<Data>
){
   fun toItemData() : Tovary{
       return Tovary(
           id = ID,
           name = NAME,
           data = data.map { it.toItemData() }
       )
   }
}