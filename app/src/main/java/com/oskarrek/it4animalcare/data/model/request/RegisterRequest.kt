package com.oskarrek.it4animalcare.data.model.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @Expose @SerializedName("login") val login : String,
    @Expose @SerializedName("haslo")val password : String,
    @Expose @SerializedName("nick")val nick : String,
    @Expose @SerializedName("numerTelefonu")val phoneNumber : Int,
    @Expose @SerializedName("email")val email : String
)