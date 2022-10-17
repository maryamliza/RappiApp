package com.kamiz.rappiapp.ui.newuser

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kamiz.rappiapp.data.RappiRepository

class NewUserViewModel(
    private val repository: RappiRepository
) : ViewModel() {
    //    val errorMessage: MutableLiveData<String> = MutableLiveData()
    val errorMessage = MutableLiveData<String>()

    fun tryNewUser(name: String, email: String, password: String, confirmPassword: String) {
        val emailSuccess = email.isLongEnough(10) && email.hasEmailChar()
        val passwordSuccess =
            password.isLongEnough(6) && password.isMixedCase() && password.hasSpecialChar()
        val confirmPasswordSuccess = password.isTheSame(confirmPassword)

        if (emailSuccess == true && passwordSuccess == true && confirmPasswordSuccess == true) {
            repository.createNewUser()
        } else {
            errorMessage.value = "Check your data"
        }

    }


    fun String.isLongEnough(numCaracters: Int): Boolean {
        return this.length >= numCaracters
    }

    fun String.hasEmailChar(): Boolean {
        return this.any { it in "@,." }
    }

    fun String.isMixedCase(): Boolean {
        return this.any(Char::isLowerCase) && this.any(Char::isUpperCase)
    }

    fun String.hasSpecialChar(): Boolean {
        return this.any { it in "!,?,^" }
    }

    fun String.isTheSame(other: String): Boolean {
        return this == other
    }

}
