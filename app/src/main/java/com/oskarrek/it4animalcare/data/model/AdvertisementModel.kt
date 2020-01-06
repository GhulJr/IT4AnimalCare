package com.oskarrek.it4animalcare.data.model

data class AdvertisementModel(
    val id : Int,
    val title : String,
    val contents : String,
    val addedTimeSpan : Long,
    val expirationTimeSpan : Long,
    val localisation : LocalisationModel
) {
    constructor(
        title : String,
        contents : String,
        addedTimeSpan : Long,
        expirationTimeSpan : Long,
        localisation : LocalisationModel
        ) : this(0, title, contents, addedTimeSpan, expirationTimeSpan, localisation)
}