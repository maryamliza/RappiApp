package com.kamiz.rappiapp.data.remote

import com.kamiz.rappiapp.data.remote.models.LoginRequest
import com.kamiz.rappiapp.data.remote.retrofit.ServiceAPI
import retrofit2.http.Body
import retrofit2.http.POST
import java.lang.Exception

class RemoteDataSource(
    private val service: ServiceAPI
) {
    suspend fun login(email: String, password: String): String {
        val body = LoginRequest(email = email, password = password)
        val response = service.login(body)
        return response.token
    }

    suspend fun forgotPassword(email: String){
        try {
            service.forgotPassword(email)
        } catch (e: Exception) {}
    }

}
