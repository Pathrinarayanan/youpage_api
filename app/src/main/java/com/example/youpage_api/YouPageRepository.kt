package com.example.youpage_api

import com.example.youpage_api.models.Items

class YouPageRepository(private val apiService: ApiService) {

    suspend fun fetchDataFromApi(): List<Items> {
        return apiService.fetchData()
    }
}
