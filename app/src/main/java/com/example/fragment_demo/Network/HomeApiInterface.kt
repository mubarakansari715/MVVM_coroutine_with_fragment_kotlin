package com.example.mvvm_coroutine_kotlin.Network

import com.example.mvvm_coroutine_kotlin.DataClasses.HomeDataClass
import retrofit2.http.GET

interface HomeApiInterface {
    @GET("photos")
    suspend fun getData(): List<HomeDataClass>
}