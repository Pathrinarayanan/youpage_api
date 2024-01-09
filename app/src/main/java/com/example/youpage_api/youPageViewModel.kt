package com.example.youpage_api


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.youpage_api.models.Items
import kotlinx.coroutines.launch

class  youPageViewModel(private val repository: YouPageRepository) : ViewModel() {

    private val _widgetData = MutableLiveData<List<Items>>()
    val widgetData: LiveData<List<Items>> get() = _widgetData

    fun fetchDataFromApi() {
        viewModelScope.launch {
            try {
                val apiResponse = repository.fetchDataFromApi()
                _widgetData.value = apiResponse
            } catch (e: Exception) {
                e.printStackTrace()

            }
        }
    }
}
