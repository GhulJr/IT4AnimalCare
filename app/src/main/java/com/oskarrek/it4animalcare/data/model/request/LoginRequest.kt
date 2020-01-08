package com.oskarrek.it4animalcare.data.model.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @Expose @SerializedName("login") val login : String,
    @Expose @SerializedName("password") val password : String
)
