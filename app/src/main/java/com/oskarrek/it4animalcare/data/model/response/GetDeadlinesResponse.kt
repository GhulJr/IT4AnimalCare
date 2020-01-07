package com.oskarrek.it4animalcare.data.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.oskarrek.it4animalcare.data.model.AdvertisementModel
import com.oskarrek.it4animalcare.data.model.DeadlineModel

data class GetDeadlinesResponse(
    @Expose @SerializedName("object") val deadlines : List<DeadlineModel>
) {
}