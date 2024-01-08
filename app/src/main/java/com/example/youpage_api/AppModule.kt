package com.example.youpage_api

import com.example.youpage_api.YouPageRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppModule {

    private val mRetrofit = Retrofit.Builder()
        .baseUrl("https://run.mocky.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService: ApiService =  mRetrofit.create(ApiService::class.java)
    val repository = YouPageRepository(apiService)
}
