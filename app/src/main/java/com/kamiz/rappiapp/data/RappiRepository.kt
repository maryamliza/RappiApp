package com.kamiz.rappiapp.data

import com.kamiz.rappiapp.data.local.LocalDataSource
import com.kamiz.rappiapp.data.model.Category
import com.kamiz.rappiapp.data.remote.RemoteDataSource

class RappiRepository(
    val remote: RemoteDataSource,
    val local: LocalDataSource,
) {
    suspend fun login(email: String, password: String): String {
        return remote.login(email, password)
    }

    suspend fun forgotPassword(email: String) {
        remote.forgotPassword(email)
    }

    suspend fun getCategories(): List<Category> {
        return remote.getCategories()
    }

    fun saveToken(token: String) {
        local.saveToken(token)
    }

    fun getToken(): String? {
        return local.getToken()
    }
}