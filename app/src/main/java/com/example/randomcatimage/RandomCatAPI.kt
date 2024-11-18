package com.example.randomcatimage

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface RandomCatAPI {

    @GET("/v1/images/search")
    suspend fun getRandomCat(): List<RandomCat>

    companion object{
        fun getInstance(): RandomCatAPI{
            return Retrofit.Builder()
                .baseUrl("https://api.thecatapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RandomCatAPI::class.java)
        }
    }
}