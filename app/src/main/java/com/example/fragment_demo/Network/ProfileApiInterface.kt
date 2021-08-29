package com.example.fragment_demo.Network

import com.example.fragment_demo.DataClasses.ProfileDataClass
import retrofit2.http.GET

interface ProfileApiInterface {
    @GET("comments")
    suspend fun ProfileAPi(): List<ProfileDataClass>
}