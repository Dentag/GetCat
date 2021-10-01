package com.dentag.getcat.api

import com.dentag.getcat.entities.CatApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CatApi {
    @GET("/v1/images/search")
    suspend fun getRandomCat(
        @Query("limit") limit: String,
        @Query("page") page: String,
        @Query("order") order: Order = Order.ASC
    ): List<CatApiResponse>

    enum class Order {
        RANDOM,
        ASC,
        DESC
    }
}
