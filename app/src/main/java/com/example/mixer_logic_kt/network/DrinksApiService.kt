package com.example.mixer_logic_kt.network

import com.example.mixer_logic_kt.model.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*


//private const val BASE_URL = "http://10.0.2.2:3003/api/" "https://metropolia-mixer.herokuapp.com/api/" "https://metropolia-mixer-backend.fly.dev"
private const val BASE_URL =   "https://metropolia-mixer-backend.fly.dev/api/"

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

    @POST("login")
    suspend fun login(@Body user: LoginRequestObj): Auth

    @POST("users")
    suspend fun getUserObject(@Header("Authorization") bearerToken: String): User

    @PUT("users/like-drink/{id}")
    suspend fun likeDrink(@Path("id") drinkId: String, @Header("Authorization") bearerToken: String): UpdatedUser

    @PUT("users/unlike-drink/{id}")
    suspend fun unlikeDrink(@Path("id") drinkId: String, @Header("Authorization") bearerToken: String): UpdatedUser
}

object DrinksApi {
    val retrofitService: DrinksApiService by lazy {
        retrofit.create(DrinksApiService::class.java)
    }
}