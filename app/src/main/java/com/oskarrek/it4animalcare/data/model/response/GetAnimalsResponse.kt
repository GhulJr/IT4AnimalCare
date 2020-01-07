package com.oskarrek.it4animalcare.data.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.oskarrek.it4animalcare.data.model.AnimalModel

data class GetAnimalsResponse(
    @Expose @SerializedName("object") val animals : List<AnimalModel>
) {
}