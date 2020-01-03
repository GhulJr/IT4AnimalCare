package com.oskarrek.it4animalcare.data.model

data class Advertisement(
    val id : Int,
    val title : String,
    val contents : String,
    val addedTimeSpan : Long,
    val expirationTimeSpan : Long,
    val localisationId : Int,
    val careId : Int,
    val scheduleId : Int
) {
}