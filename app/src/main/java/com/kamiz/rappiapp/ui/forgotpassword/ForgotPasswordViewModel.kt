package com.kamiz.rappiapp.ui.forgotpassword

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kamiz.rappiapp.data.RappiRepository
import kotlinx.coroutines.launch

class ForgotPasswordViewModel(
    private val repository: RappiRepository,
) : ViewModel() {

}