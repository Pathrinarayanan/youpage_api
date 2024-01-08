package com.example.youpage_api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RecyclerViewModelFactory(private val repository: YouPageRepository) : ViewModelProvider.Factory {

//    @Suppress("UNCHECKED_CAST", "JvmSuppressWildcards")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(youPageViewModel::class.java)) {
            return youPageViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
