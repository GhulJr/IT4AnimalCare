package com.oskarrek.it4animalcare.ui.main

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oskarrek.it4animalcare.data.model.UserModel
import com.oskarrek.it4animalcare.data.repository.ApiRepository

class MainViewModel : ViewModel() {

    val loggedUser = MutableLiveData<UserModel>()

    fun isLogged(login : String, password : String) {

    }

    @SuppressLint("CheckResult")
    fun signOut() {
        ApiRepository.logoutUser(loggedUser.value?.login ?: "")
            .subscribe( {success ->
                loggedUser.postValue(null)},
                {error ->
                    error.printStackTrace()})
    }
}