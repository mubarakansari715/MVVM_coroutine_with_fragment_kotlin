package com.example.fragment_demo.Repository

import com.example.fragment_demo.DataClasses.ProfileDataClass
import com.example.mvvm_coroutine_kotlin.Objects.RetrofitBulder

class ProfileRepository {
    suspend fun getProfileRepository():List<ProfileDataClass> = RetrofitBulder.PROFILE_API.ProfileAPi()
}