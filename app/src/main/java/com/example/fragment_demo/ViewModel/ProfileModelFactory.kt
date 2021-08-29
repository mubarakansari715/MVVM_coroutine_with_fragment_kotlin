package com.example.fragment_demo.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fragment_demo.Repository.ProfileRepository

class ProfileModelFactory(private val getProfileRepository: ProfileRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProfileViewModel(getProfileRepository) as T
    }

}