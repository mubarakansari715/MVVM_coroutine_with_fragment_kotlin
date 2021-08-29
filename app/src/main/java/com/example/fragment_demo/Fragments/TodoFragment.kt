package com.example.fragment_demo.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragment_demo.Adapters.TodoAdapter
import com.example.fragment_demo.DataClasses.ProfileDataClass
import com.example.fragment_demo.DataClasses.TodoDataClass
import com.example.fragment_demo.R
import com.example.fragment_demo.Repository.ProfileRepository
import com.example.fragment_demo.Repository.TodoRepository
import com.example.fragment_demo.ViewModel.ProfileModelFactory
import com.example.fragment_demo.ViewModel.ProfileViewModel
import com.example.fragment_demo.ViewModel.TodoViewModel
import com.example.fragment_demo.ViewModel.TodoViewModelFactory
import com.example.mvvm_coroutine_kotlin.DataClasses.HomeDataClass
import com.example.mvvm_coroutine_kotlin.Repository.HomeRepository
import com.example.mvvm_coroutine_kotlin.ViewModel.HomeModelFactory
import com.example.mvvm_coroutine_kotlin.ViewModel.HomeViewModel

class TodoFragment : Fragment() {
    private lateinit var todoAdapter: TodoAdapter
    private lateinit var todoViewMode: TodoViewModel
    private lateinit var recycleview: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_todo, container, false)
        TodoData(view)
        return view
    }

    private fun TodoData(view: View) {
        recycleview = view.findViewById<RecyclerView>(R.id.recyclerView_todo)
        recycleview.layoutManager = LinearLayoutManager(requireContext())
        todoAdapter = TodoAdapter(requireContext(),ArrayList())
        recycleview.adapter = todoAdapter

        val repository = TodoRepository()
        val todomodelFactory = TodoViewModelFactory(repository)
        todoViewMode = ViewModelProvider(this, todomodelFactory)[TodoViewModel::class.java]
        todoViewMode.fetchTodoData()
        todoViewMode.liveTodoDataList.observe(viewLifecycleOwner, Observer {
            todoAdapter.TodoDetails(it as List<TodoDataClass>)
            recycleview.visibility = View.VISIBLE
        })
    }


}