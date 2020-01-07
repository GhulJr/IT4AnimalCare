package com.oskarrek.it4animalcare.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AdvertisementModel(
    @Expose @SerializedName("id") val id : Int,
    @Expose @SerializedName("title") val title : String,
    @Expose @SerializedName("contents") val contents : String,
    @Expose @SerializedName("addedTimeSpan") val addedTimeSpan : Long,
    @Expose @SerializedName("expirationTimeSpan") val expirationTimeSpan : Long?,
    @Expose @SerializedName("localisation") val localisation : LocalisationModel
) : Serializable{
    constructor(
        title : String,
        contents : String,
        addedTimeSpan : Long,
        expirationTimeSpan : Long,
        localisation : LocalisationModel
        ) : this(0, title, contents, addedTimeSpan, expirationTimeSpan, localisation)
}