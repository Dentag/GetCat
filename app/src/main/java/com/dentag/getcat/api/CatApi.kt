package com.dentag.getcat.api

import com.dentag.getcat.model.entities.CatDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApi {
    @GET("/v1/images/search")
    suspend fun getCatsPage(
        @Query("limit") limit: String,
        @Query("page") page: String,
        @Query("order") order: Order = Order.ASC
    ): Response<List<CatDto>>

    enum class Order {
        RANDOM,
        ASC,
        DESC
    }
}
