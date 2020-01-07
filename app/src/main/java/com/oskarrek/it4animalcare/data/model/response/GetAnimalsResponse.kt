package com.oskarrek.it4animalcare.data.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.oskarrek.it4animalcare.data.model.AnimalModel
import com.oskarrek.it4animalcare.data.model.DeadlineModel

data class GetAnimalsResponse(
    @Expose @SerializedName("object") val animals : List<AnimalModel>
) {
}