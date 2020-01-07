package com.oskarrek.it4animalcare.ui.common.deadlines_list

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oskarrek.it4animalcare.data.model.DeadlineModel
import com.oskarrek.it4animalcare.data.repository.ApiRepository

@RequiresApi(Build.VERSION_CODES.N)
class DeadlinesViewModel : ViewModel() {
    val deadlines = MutableLiveData<List<DeadlineModel>>()
    val apiRepository =
        ApiRepository        //TODo: make private set

    @SuppressLint("CheckResult")
    fun getDeadlines(id : Int) {
        apiRepository
            .getAdvertisementDeadlines(id)
            .subscribe ({ value ->  deadlines.postValue(value) }, { error -> error.printStackTrace()})
    }
}
