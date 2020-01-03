package com.oskarrek.it4animalcare.ui.advertisment.fragments.notice_board

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.oskarrek.it4animalcare.data.model.AdvertisementModel

class NoticeBoardViewModel : ViewModel(){

    val advertsements = emptyList<AdvertisementModel>()


    /*private val _text = MutableLiveData<String>().apply {
    }
    val text: LiveData<String> = _text*/
}