package com.oskarrek.it4animalcare.data.model

data class DeadlineModel(
    val id : Int,
    val timeSpan : Long,
    val isTaken : Boolean
) {
    constructor(timeInMillis : Long) : this(0, timeInMillis, false)
}