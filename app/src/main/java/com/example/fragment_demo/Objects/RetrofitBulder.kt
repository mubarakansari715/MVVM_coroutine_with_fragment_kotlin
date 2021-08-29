package com.example.mvvm_coroutine_kotlin.Objects

import com.example.fragment_demo.Network.ProfileApiInterface
import com.example.fragment_demo.Network.TodoApiInterface
import com.example.mvvm_coroutine_kotlin.Network.HomeApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBulder{
    private val url = "https://jsonplaceholder.typicode.com/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(url)
            .build()
    }
    val HOME_API: HomeApiInterface by lazy {
        retrofit.create(HomeApiInterface::class.java)
    }
    val PROFILE_API: ProfileApiInterface by lazy {
        retrofit.create(ProfileApiInterface::class.java)
    }
    val TODO_API :TodoApiInterface by lazy {
        retrofit.create(TodoApiInterface::class.java)
    }
}