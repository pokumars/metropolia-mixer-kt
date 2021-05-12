package com.example.mixer_logic_kt.network

import com.example.mixer_logic_kt.model.Auth
import com.example.mixer_logic_kt.model.Drink2
import com.example.mixer_logic_kt.model.LoginRequestObj
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


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



    @POST("login")
    suspend fun login(@Body user: LoginRequestObj): Auth

    @GET("group/{id}/users")
    fun groupList(@Path("id") groupId: Int): List<String>

}

object DrinksApi {
    val retrofitService: DrinksApiService by lazy {
        retrofit.create(DrinksApiService::class.java)
    }
}