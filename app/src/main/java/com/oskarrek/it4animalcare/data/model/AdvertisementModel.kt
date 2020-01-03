package com.oskarrek.it4animalcare.data.model

data class AdvertisementModel(
    val id : Int,
    val title : String,
    val contents : String,
    val addedTimeSpan : Long,
    val expirationTimeSpan : Long,
    val localisationId : Int,
    val careId : Int,
    val scheduleId : Int
) {
    constructor(
        title : String,
        contents : String,
        addedTimeSpan : Long,
        expirationTimeSpan : Long,
        localisationId : Int)
            : this(0, title, contents, addedTimeSpan, expirationTimeSpan, localisationId, 0 ,0)
}