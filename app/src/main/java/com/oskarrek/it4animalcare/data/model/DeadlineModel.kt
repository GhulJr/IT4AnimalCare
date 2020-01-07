package com.oskarrek.it4animalcare.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DeadlineModel(
    @Expose @SerializedName("id") val id : Int,
    @Expose @SerializedName("timeSpan") val timeSpan : Long,
    @Expose @SerializedName("isTaken") val isTaken : Boolean
) {
    constructor(timeInMillis : Long) : this(0, timeInMillis, false)
}