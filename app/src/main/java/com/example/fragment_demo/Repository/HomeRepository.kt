package com.example.mvvm_coroutine_kotlin.Repository

import com.example.mvvm_coroutine_kotlin.DataClasses.HomeDataClass
import com.example.mvvm_coroutine_kotlin.Objects.RetrofitBulder

class HomeRepository  {
    suspend fun getHomeRepository ():List<HomeDataClass> = RetrofitBulder.HOME_API.getData()
}