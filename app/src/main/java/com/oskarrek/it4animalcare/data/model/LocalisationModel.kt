package com.oskarrek.it4animalcare.data.model

data class LocalisationModel(
    val id : Int,
    val city : String,
    val post_code : String
) {
    constructor(
        city: String,
        post_code: String
    ) : this(0, city, post_code)

    override fun toString(): String {
        return "$city, $post_code"
    }
}