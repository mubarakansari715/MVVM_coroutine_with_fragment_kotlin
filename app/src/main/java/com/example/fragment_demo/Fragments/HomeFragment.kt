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
import com.example.fragment_demo.R
import com.example.mvvm_coroutine_kotlin.Adapters.HomeAdapter
import com.example.mvvm_coroutine_kotlin.DataClasses.HomeDataClass
import com.example.mvvm_coroutine_kotlin.Repository.HomeRepository
import com.example.mvvm_coroutine_kotlin.ViewModel.HomeModelFactory
import com.example.mvvm_coroutine_kotlin.ViewModel.HomeViewModel


class HomeFragment : Fragment() {
    private lateinit var homeAdapter: HomeAdapter
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        saveHomeData(view)
        return view
    }

    private fun saveHomeData(view: View) {
        recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        homeAdapter = HomeAdapter(requireContext(), ArrayList())
        recyclerView.adapter = homeAdapter

        val repository = HomeRepository()
        val datamodelFactory = HomeModelFactory(repository)
        homeViewModel = ViewModelProvider(this, datamodelFactory)[HomeViewModel::class.java]
        homeViewModel.FetchData()
        homeViewModel.liveHomeDataList.observe(viewLifecycleOwner, Observer {
            homeAdapter.saveData(it as List<HomeDataClass>)
            recyclerView.visibility = View.VISIBLE
        })
    }
}