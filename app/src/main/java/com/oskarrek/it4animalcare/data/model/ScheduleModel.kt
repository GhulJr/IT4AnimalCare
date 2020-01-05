package com.oskarrek.it4animalcare.data.model

data class ScheduleModel(
    val id : Int,
    val deadlines : ArrayList<DeadlineModel>
) {
    constructor(deadlines: ArrayList<DeadlineModel>) : this(0, deadlines)
}