package com.example.mvvm_coroutine_kotlin.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_coroutine_kotlin.Repository.HomeRepository

class HomeModelFactory (private val homeRepository: HomeRepository)  : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(homeRepository) as T
    }
}