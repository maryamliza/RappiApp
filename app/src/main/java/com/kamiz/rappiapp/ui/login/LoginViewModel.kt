package com.kamiz.rappiapp.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kamiz.rappiapp.data.RappiRepository
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: RappiRepository,
) : ViewModel() {
    val tokenResponse: MutableLiveData<String> = MutableLiveData()
    val showErrorToast: MutableLiveData<String> = MutableLiveData()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val token = repository.login(email, password)
                tokenResponse.value = token
            } catch (e: Exception) {
                showErrorToast.value = "Wrong Credentials"
            }
        }
    }

    fun tryLogin(email: String, password: String) {

        val errorMessage = if (email.isEmpty()) {
            "email vacio"
        } else if (!email.contains("@")) {
            "email no tiene @"
        } else if (password.isEmpty()) {
            "password vacio"
        } else if (password.length < 6) {
            "password tiene menos de 6 caracteres"
        } else {
            null
        }

//        val errorMessage = when {
//            email.isEmpty() -> "email vacio"
//            !email.contains("@") -> "email no tiene @"
//            password.isEmpty() -> "password vacio"
//            password.length < 6 -> "password tiene menos de 6 caracteres"
//            else -> null
//        }

        if (errorMessage != null) {
            showErrorToast.value = errorMessage
        } else {
            login(email = email, password = password)
        }

    }

}