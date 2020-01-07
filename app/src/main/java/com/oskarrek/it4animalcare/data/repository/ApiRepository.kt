package com.oskarrek.it4animalcare


import android.os.Build
import android.util.AndroidException
import androidx.annotation.RequiresApi
import com.oskarrek.it4animalcare.data.model.AdvertisementModel
import com.oskarrek.it4animalcare.data.source.remote.RetrofitClientGenerator
import com.oskarrek.it4animalcare.data.source.remote.api.AdvertisementsApi
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object ApiRepository {

    @RequiresApi(Build.VERSION_CODES.N)
    private val advertisementsApi = RetrofitClientGenerator.createClient(AdvertisementsApi::class.java)

    @RequiresApi(Build.VERSION_CODES.N)
    fun getAdvertisements() : Single<List<AdvertisementModel>> {
       return advertisementsApi
           .getAdvertisements()
           .subscribeOn(Schedulers.single())
           .observeOn(AndroidSchedulers.mainThread())
    }

}