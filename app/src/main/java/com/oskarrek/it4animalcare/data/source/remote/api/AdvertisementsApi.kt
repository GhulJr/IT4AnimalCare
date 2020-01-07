package com.oskarrek.it4animalcare.data.source.remote.api

import com.oskarrek.it4animalcare.data.model.AdvertisementModel
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import java.util.*

interface AdvertisementsApi {

    @GET("/general/get_advertisement_info")
    fun getAdvertisements() : Single<List<AdvertisementModel>>
}