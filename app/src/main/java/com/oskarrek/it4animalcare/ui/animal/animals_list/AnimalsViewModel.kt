package com.oskarrek.it4animalcare.ui.animal.animals_list

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oskarrek.it4animalcare.data.model.AnimalModel
import com.oskarrek.it4animalcare.data.repository.ApiRepository

class AnimalsViewModel : ViewModel() {
    val animals = MutableLiveData<List<AnimalModel>>()
    val apiRepository =
        ApiRepository        //TODo: make private set

    @SuppressLint("CheckResult")
    fun getDeadlines(id : Int) {
        apiRepository
            .getAdvertisementAnimals(id)
            .subscribe ({ value ->  animals.postValue(value) }, { error -> error.printStackTrace()})
    }
}
