package com.kamiz.rappiapp.ui.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kamiz.rappiapp.data.RappiRepository
import com.kamiz.rappiapp.data.model.Category
import kotlinx.coroutines.launch

class SplashViewModel(
    private val repository: RappiRepository,
) : ViewModel() {
}