package com.kamiz.rappiapp.ui.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kamiz.rappiapp.data.RappiRepository

class SplashViewModel(
    private val repository: RappiRepository,
) : ViewModel() {
    val savedToken: MutableLiveData<String> = MutableLiveData()

    init {
        getToken()
    }

    fun getToken() {
        savedToken.value = repository.getToken()
    }
}