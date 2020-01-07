package com.oskarrek.it4animalcare.data.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.oskarrek.it4animalcare.data.model.AdvertisementModel

data class GetAdvertisementsResponse(
    @Expose @SerializedName("object") val advertisements : List<AdvertisementModel>
)