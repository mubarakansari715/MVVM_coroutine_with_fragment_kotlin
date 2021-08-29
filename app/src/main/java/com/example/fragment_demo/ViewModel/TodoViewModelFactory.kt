package com.example.fragment_demo.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fragment_demo.Repository.TodoRepository

class TodoViewModelFactory(private val getTodoRepository: TodoRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TodoViewModel(getTodoRepository) as T
    }
}