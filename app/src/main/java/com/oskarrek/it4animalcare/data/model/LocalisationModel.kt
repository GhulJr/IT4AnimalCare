package com.oskarrek.it4animalcare.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LocalisationModel(
    @Expose @SerializedName("id") val id : Int,
    @Expose @SerializedName("city") val city : String,
    @Expose @SerializedName("postCode") val postCode : String?
) : Serializable {
    constructor(
        city: String,
        post_code: String
    ) : this(0, city, post_code)

    override fun toString(): String {
        return if(postCode == null)"$city, $postCode" else "$city"
    }
}