package com.kamiz.rappiapp.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kamiz.rappiapp.data.RappiRepository
import kotlinx.coroutines.launch

class LoginViewModel(
    val repository: RappiRepository,
) : ViewModel() {
    val tokenResponse: MutableLiveData<String> = MutableLiveData()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            tokenResponse.value = repository.login(email, password)
        }
    }
}