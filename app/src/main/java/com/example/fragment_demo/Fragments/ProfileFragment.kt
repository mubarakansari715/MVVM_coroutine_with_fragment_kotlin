package com.example.mvvm_coroutine_with_fragment_kotlin.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragment_demo.Adapters.ProfileAdapter
import com.example.fragment_demo.DataClasses.ProfileDataClass
import com.example.fragment_demo.R
import com.example.fragment_demo.Repository.ProfileRepository
import com.example.fragment_demo.ViewModel.ProfileModelFactory
import com.example.fragment_demo.ViewModel.ProfileViewModel


class ProfileFragment : Fragment() {
    private lateinit var recyclerView_profile: RecyclerView
    private lateinit var profieAdapter: ProfileAdapter
    private lateinit var profileViewModel :ProfileViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        saveProfileData(view)
        return view
    }

    private fun saveProfileData(view: View) {
        recyclerView_profile = view.findViewById<RecyclerView>(R.id.recyclerView_profile)
        recyclerView_profile.layoutManager = LinearLayoutManager(activity)
        profieAdapter = ProfileAdapter(requireContext(), ArrayList())
        recyclerView_profile.adapter = profieAdapter

        val repository = ProfileRepository()
        val datamodelFactory = ProfileModelFactory(repository)
        profileViewModel = ViewModelProvider(this, datamodelFactory)[ProfileViewModel::class.java]
        profileViewModel.ProdileDataFatch()
        profileViewModel.liveProfileDataList.observe(viewLifecycleOwner, Observer {
            profieAdapter.PersonSavedData(it as List<ProfileDataClass>)
            recyclerView_profile.visibility = View.VISIBLE
        })

    }

}