package com.oskarrek.it4animalcare.ui.main.notice_board

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.databinding.BaseObservable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oskarrek.it4animalcare.ApiRepository
import com.oskarrek.it4animalcare.data.model.AdvertisementModel

@RequiresApi(Build.VERSION_CODES.N)
class NoticeBoardViewModel : ViewModel() {

    val advertsements = MutableLiveData<List<AdvertisementModel>>()
    val apiRepository = ApiRepository

    init {
        getAdvertisements()
    }

    @SuppressLint("CheckResult")
    private fun getAdvertisements() {
        apiRepository
            .getAdvertisements()
            .subscribe { value ->  advertsements.postValue(value) }
    }
}
