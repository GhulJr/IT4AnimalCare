package com.oskarrek.it4animalcare.data.model

data class AdvertisementModel(
    val id : Int,
    val title : String,
    val contents : String,
    val addedTimeSpan : Long,
    val expirationTimeSpan : Long,
    val localisation : LocalisationModel,
    val care : CareModel,
    val deadlines : MutableList<DeadlineModel>
) {
    constructor(
        title : String,
        contents : String,
        addedTimeSpan : Long,
        expirationTimeSpan : Long,
        localisation : LocalisationModel,
        care : CareModel,
        deadlines : MutableList<DeadlineModel> )
            : this(0, title, contents, addedTimeSpan, expirationTimeSpan, localisation, care, deadlines)
}