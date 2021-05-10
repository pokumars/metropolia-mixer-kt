package com.example.mixer_logic_kt.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://10.0.2.2:3003/api/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface DrinksApiService{
    @GET("drinks")
    suspend fun getDrinks(): String
}

object DrinksApi {
    val retrofitService: DrinksApiService by lazy {
        retrofit.create(DrinksApiService::class.java)
    }
}