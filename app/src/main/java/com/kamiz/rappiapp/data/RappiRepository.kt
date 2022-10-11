package com.kamiz.rappiapp.data

import com.kamiz.rappiapp.data.local.sharepreferences.PreferencesManager
import com.kamiz.rappiapp.data.remote.RemoteDataSource

class RappiRepository(
    private val remote: RemoteDataSource,
    private val preferencesManager: PreferencesManager,
) {
    suspend fun login(email: String, password: String): String {
        val token = remote.login(email, password)
        preferencesManager.saveToken(token)
        return token
    }
}