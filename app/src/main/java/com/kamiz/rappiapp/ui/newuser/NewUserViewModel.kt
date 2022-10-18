package com.kamiz.rappiapp.ui.newuser

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kamiz.rappiapp.data.RappiRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NewUserViewModel(
    private val repository: RappiRepository
) : ViewModel() {
    //    val errorMessage: MutableLiveData<String> = MutableLiveData()
    val errorMessage = MutableLiveData<String>()
    val successMessage = MutableLiveData<String>()

    fun tryNewUser(name: String, email: String, password: String, confirmPassword: String) {
        viewModelScope.launch {
            val nameSuccess = name.isLongEnough(1)
            val emailSuccess = email.isLongEnough(10) && email.hasEmailChar()
            val passwordSuccess =
                password.isLongEnough(6) && password.isMixedCase() && password.hasSpecialChar()
            val confirmPasswordSuccess = password.isTheSame(confirmPassword)

            if (emailSuccess == true && passwordSuccess == true && confirmPasswordSuccess == true) {
                createNewUser()
            } else if (nameSuccess == false) {
                errorMessage.value = "Please, complete the user name"
            } else if (emailSuccess == false) {
                errorMessage.value = "Please, write a email like example@gmail.com"
            } else if (passwordSuccess == false) {
                errorMessage.value =
                    "Please use at less 6 characters,lowercase,uppercase and special char"
            } else if (confirmPasswordSuccess == false) {
                errorMessage.value =
                    "Please, check your confirm password. You need to write the same password"
            }
        }
    }

    fun createNewUser() {
        viewModelScope.launch {
            repository.createNewUser()
            delay(2 * 1000)
            successMessage.value = "New user created"
        }
    }


    fun String.isLongEnough(numCaracters: Int): Boolean {
        return this.length >= numCaracters
    }

    fun String.hasEmailChar(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(this).matches()
//        return this.any { it in "@" } && this.any { it in "." }
    }

    fun String.isMixedCase(): Boolean {
        return this.any(Char::isLowerCase) && this.any(Char::isUpperCase)
    }

    fun String.hasSpecialChar(): Boolean {
        return this.any { it in "!,?,^,$" }
    }

    fun String.isTheSame(other: String): Boolean {
        return this == other
    }

}
