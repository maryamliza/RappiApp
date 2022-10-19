package com.kamiz.rappiapp.data.remote.retrofit

import com.kamiz.rappiapp.data.model.Category
import com.kamiz.rappiapp.data.model.Product
import com.kamiz.rappiapp.data.remote.responses.ForgotPasswordRequest
import com.kamiz.rappiapp.data.remote.responses.LoginRequest
import com.kamiz.rappiapp.data.remote.responses.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ServiceAPI {
    @POST("login")
    suspend fun login(@Body body: LoginRequest): LoginResponse

    @POST("forgotpassword")
    suspend fun forgotPassword(@Body body: ForgotPasswordRequest): Response<Any?>
    // Response<Any?> is handling 204 response

    @GET("categories")
    suspend fun getCategories(): List<Category>

    @POST("signup")
    suspend fun createNewUser():Response<Any>

    @GET("search")
    suspend fun searchText(searchWord:String):List<Product>

}