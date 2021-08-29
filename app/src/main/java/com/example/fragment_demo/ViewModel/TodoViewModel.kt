package com.example.fragment_demo.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fragment_demo.DataClasses.TodoDataClass
import com.example.fragment_demo.Repository.TodoRepository
import kotlinx.coroutines.launch

class TodoViewModel(private val getTodoRepository: TodoRepository) :ViewModel() {
    val liveTodoDataList : MutableLiveData<List<TodoDataClass>> = MutableLiveData()

    fun fetchTodoData(){
        viewModelScope.launch {
            val result = getTodoRepository.GetTodoRepository()
            liveTodoDataList.value = result
        }
    }
}