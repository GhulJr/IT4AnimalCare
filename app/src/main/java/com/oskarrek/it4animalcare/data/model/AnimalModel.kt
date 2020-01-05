package com.oskarrek.it4animalcare.data.model

data class AnimalModel(
    val id: Int,
    val name: String,
    val species: String,
    val age: Int?,
    val sex: Boolean?
) {
    constructor(
        name: String,
        species: String,
        age: Int?,
        sex: Boolean?
    ) : this(0, name, species, age, sex)
}