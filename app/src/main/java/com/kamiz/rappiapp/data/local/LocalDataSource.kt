package com.kamiz.rappiapp.data.local

import com.kamiz.rappiapp.data.local.preferences.PreferencesManager

class LocalDataSource(
    private val preferencesManager: PreferencesManager,
) {
    fun saveToken(token: String) {
        preferencesManager.saveToken(token)
    }

    fun getToken(): String? {
        return preferencesManager.getToken()
    }
}