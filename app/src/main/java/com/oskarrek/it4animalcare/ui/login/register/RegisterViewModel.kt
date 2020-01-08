package com.oskarrek.it4animalcare.ui.login.register

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oskarrek.it4animalcare.data.model.request.RegisterRequest
import com.oskarrek.it4animalcare.data.model.response.ApiResult
import com.oskarrek.it4animalcare.data.repository.ApiRepository


class RegisterViewModel : ViewModel() {

    val registerResult = MutableLiveData<ApiResult>()
    val isValid = MutableLiveData<Boolean>()

    init {
        isValid.value = false
    }

    @SuppressLint("CheckResult")
    fun registerUser(registerRequest : RegisterRequest) {
        ApiRepository.registerUser(registerRequest).subscribe({ success ->
            registerResult.postValue(success.body())
        }, { error ->
            error.printStackTrace()
        })
    }

    fun registerDataChanged(
        login : String,
        password : String,
        nick : String,
        email : String,
        phoneNumber : String
    ) {
        isValid.value = when {
            !isUserNameValid(login) -> false
            !isPasswordValid(password) -> false
            !isNickValid(nick) -> false
            !isEmailValid(email) -> false
            !isPhoneNumberValid(phoneNumber) -> false
            else -> true
        }
    }

    private fun isUserNameValid(login : String) : Boolean= !(login.isBlank() || login.length < 5)
    private fun isPasswordValid(password : String) : Boolean = !(password.isBlank() || password.length < 7)
    private fun isNickValid(nick : String) : Boolean = !(nick.isBlank() || nick.length < 5)
    private fun isEmailValid(email : String) : Boolean = !(email.isBlank() || email.length < 5)// && (email.contains("@")  && email.contains("."))
    private fun isPhoneNumberValid(phoneNumber : String) : Boolean = !(phoneNumber.isBlank() || phoneNumber.length < 9)
}