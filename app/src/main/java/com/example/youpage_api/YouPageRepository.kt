package com.example.youpage_api

import android.content.ClipData.Item
import com.example.youpage_api.ApiResponse
import com.example.youpage_api.ApiService

class YouPageRepository(private val apiService: ApiService) {

    suspend fun fetchDataFromApi(): List<Items> {
        return apiService.fetchData()
    }
}
