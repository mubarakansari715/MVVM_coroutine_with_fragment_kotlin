package com.example.fragment_demo.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fragment_demo.DataClasses.ProfileDataClass
import com.example.fragment_demo.Repository.ProfileRepository
import kotlinx.coroutines.launch

class ProfileViewModel (private val profileRepository: ProfileRepository) : ViewModel(){

    val liveProfileDataList: MutableLiveData<List<ProfileDataClass>> = MutableLiveData()
    fun ProdileDataFatch(){
        viewModelScope.launch {
            val response = profileRepository.getProfileRepository()
            liveProfileDataList.value = response
        }
    }
}