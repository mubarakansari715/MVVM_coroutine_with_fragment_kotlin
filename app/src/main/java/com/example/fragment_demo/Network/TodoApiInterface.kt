package com.example.fragment_demo.Network

import com.example.fragment_demo.DataClasses.TodoDataClass
import retrofit2.http.GET

interface TodoApiInterface {
    @GET("todos")
    suspend fun getDataTodo(): List<TodoDataClass>
}