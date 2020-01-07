package com.oskarrek.it4animalcare.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AnimalModel(
    @Expose @SerializedName("id") val id: Int,
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("Spieces") val species: String,
    @Expose @SerializedName("age") val age: Int?,
    @Expose @SerializedName("sex") val sex: Boolean?
) {
    constructor(
        name: String,
        species: String,
        age: Int?,
        sex: Boolean?
    ) : this(0, name, species, age, sex)
}