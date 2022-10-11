package com.kamiz.rappiapp.data.remote.retrofit

import com.kamiz.rappiapp.data.models.User
import com.kamiz.rappiapp.data.remote.models.LoginResponse
import com.kamiz.rappiapp.data.remote.models.LoginRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ServiceAPI {
    @POST("login")
    suspend fun login(@Body body: LoginRequest): LoginResponse

    @GET("user")
    suspend fun getUserInformation(@Header("Authorization") token:String): User
}