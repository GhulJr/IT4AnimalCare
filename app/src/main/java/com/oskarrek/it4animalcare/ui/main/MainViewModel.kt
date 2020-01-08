package com.oskarrek.it4animalcare.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oskarrek.it4animalcare.data.model.UserModel

class MainViewModel : ViewModel() {

    val loggedUser = MutableLiveData<UserModel>()

    init {
        loggedUser.postValue(null)
    }

    fun isLogged(login : String, password : String) {

    }
}