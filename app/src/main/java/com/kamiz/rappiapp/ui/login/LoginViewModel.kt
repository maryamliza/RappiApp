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
                tokenResponse.value = repository.login(email, password)
            } catch (e: Exception) {
                error.value = "Wrong Credentials"
            }
        }
    }
}