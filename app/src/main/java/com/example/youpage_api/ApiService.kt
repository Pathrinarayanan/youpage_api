package com.example.youpage_api

import com.example.youpage_api.ApiResponse
import retrofit2.http.GET

interface ApiService {
    @GET("v3/05195fcc-088b-46e0-bcc9-a8c05e41004d")
    suspend fun fetchData(): List<Items>
}
