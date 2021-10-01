package com.dentag.getcat.api

import com.dentag.getcat.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


fun getCatApi(): CatApi {
    val httpClient = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor(BuildConfig.CAT_API_KEY))
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.thecatapi.com")
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(CatApi::class.java)
}
