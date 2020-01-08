package com.oskarrek.it4animalcare.ui.login.ui.login

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.data.model.UserModel
import com.oskarrek.it4animalcare.data.model.request.LoginRequest
import com.oskarrek.it4animalcare.data.repository.ApiRepository
import com.oskarrek.it4animalcare.ui.login.data.LoginRepository
import retrofit2.Response


class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    val loginResponse = MutableLiveData<UserModel>()

    @SuppressLint("CheckResult")
    fun login(username: String, password: String) {
        ApiRepository.loginUser(LoginRequest(username, password))
            .subscribe(
                {success ->
                    loginResponse.postValue(success)},
                {error ->
                    loginResponse.postValue(null)
                    error.printStackTrace()})
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 6
    }
}
