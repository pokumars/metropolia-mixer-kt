package com.example.mixer_logic_kt.network

import com.example.mixer_logic_kt.model.Drink2
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://10.0.2.2:3003/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))//The converter tells Retrofit what to do with the data it gets back from the web service
    .baseUrl(BASE_URL)
    .build()

interface DrinksApiService{
    @GET("drinks")
    suspend fun getDrinks(): List<Drink2>
}

object DrinksApi {
    val retrofitService: DrinksApiService by lazy {
        retrofit.create(DrinksApiService::class.java)
    }
}