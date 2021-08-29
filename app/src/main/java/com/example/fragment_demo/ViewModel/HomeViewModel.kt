package com.example.mvvm_coroutine_kotlin.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_coroutine_kotlin.DataClasses.HomeDataClass
import com.example.mvvm_coroutine_kotlin.Repository.HomeRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {
    val liveHomeDataList: MutableLiveData<List<HomeDataClass>> = MutableLiveData()

    fun FetchData() {

        viewModelScope.launch {
            try {
                val result = homeRepository.getHomeRepository()
                liveHomeDataList.value = result
            } catch (e: Exception) {
                Log.d("myTag", "fetchData: Something is Wrong")
            }
        }
    }
}