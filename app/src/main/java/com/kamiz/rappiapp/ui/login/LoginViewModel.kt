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
    val error: MutableLiveData<String> = MutableLiveData()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val token = repository.login(email, password)
                tokenResponse.value = token

            } catch (e: Exception) {
                error.value = "Wrong Credentials"
            }
        }
    }

    fun checkForErrors(email: String, password: String): String? {
        if (email.isEmpty()) {
            // email vacio
            return "email vacio"
        } else if (!email.contains("@")) {
            // email no tenga @
            return "email no tiene @"
        } else if (password.isEmpty()) {
            // password este vacio
            return "password vacio"
        } else if (password.length < 6) {
            // password tenga menos de 6 caracteres
            return "password tiene menos de 6 caracteres"
        } else {
            // esta toodo bien mano. Todod xvr!
            return null
        }
    }

}