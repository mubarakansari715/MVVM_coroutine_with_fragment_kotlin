package com.example.fragment_demo.Repository

import com.example.fragment_demo.DataClasses.TodoDataClass
import com.example.mvvm_coroutine_kotlin.Objects.RetrofitBulder

class TodoRepository {
    suspend fun GetTodoRepository():List<TodoDataClass> = RetrofitBulder.TODO_API.getDataTodo()
}