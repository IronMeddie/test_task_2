package com.ironmeddie.test_task2.data.remote

import com.ironmeddie.test_task2.data.dto.ProductsDto
import retrofit2.http.GET


interface ApiService {

    @GET("/newmobile/glavnaya/super_top.php?action=topglav")
    suspend fun getData() : ProductsDto

}

