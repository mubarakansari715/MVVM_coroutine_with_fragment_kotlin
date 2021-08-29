package com.example.fragment_demo.DataClasses


class  TodoDataClassItem: ArrayList<TodoDataClass>()
data class TodoDataClass(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int,
)