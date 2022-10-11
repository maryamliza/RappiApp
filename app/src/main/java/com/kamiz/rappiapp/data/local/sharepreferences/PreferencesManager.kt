package com.kamiz.rappiapp.data.local.sharepreferences

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(
    private val context: Context
) {
    private val sharedPrefs: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun getToken(): String? {
        return sharedPrefs.getString(TOKEN_KEY, null)
    }

    fun saveToken(token: String) {
        sharedPrefs.edit().putString(TOKEN_KEY, token).apply()
    }

    companion object {
        private const val PREFS_NAME = "rappiapppreferences"
        private const val TOKEN_KEY = "TOKEN"
    }

}