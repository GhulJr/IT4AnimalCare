package com.oskarrek.it4animalcare.ui.login.register

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.oskarrek.it4animalcare.data.model.UserModel
import com.oskarrek.it4animalcare.data.model.request.RegisterRequest
import com.oskarrek.it4animalcare.data.model.response.RegisterResult
import com.oskarrek.it4animalcare.data.repository.ApiRepository
import io.reactivex.Single
import retrofit2.HttpException
import retrofit2.Response

class RegisterViewModel : ViewModel() {

    val registerResult = MutableLiveData<RegisterResult>()


    @SuppressLint("CheckResult")
    fun registerUser(registerRequest : RegisterRequest) {
        ApiRepository.registerUser(registerRequest).subscribe({ success ->
            registerResult.postValue(success.body())
        }, { error ->
            error.printStackTrace()
        })
    }
}