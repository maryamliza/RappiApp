package com.kamiz.rappiapp.data

import com.kamiz.rappiapp.data.local.LocalDataSource
import com.kamiz.rappiapp.data.model.Category
import com.kamiz.rappiapp.data.remote.RemoteDataSource

class RappiRepository(
    private val remote: RemoteDataSource,
    private val local: LocalDataSource,
) {
    suspend fun login(email: String, password: String): String {
        val token = remote.login(email, password)
        local.saveToken(token)
        return token
    }

    suspend fun forgotPassword(email: String) {
        remote.forgotPassword(email)
    }

    suspend fun getCategories(): List<Category> {
        return remote.getCategories()
    }

    fun getToken(): String? {
        return local.getToken()
    }

    fun createNewUser() {
        TODO("Not yet implemented")
    }
}