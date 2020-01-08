package com.oskarrek.it4animalcare.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserModel(
    @Expose @SerializedName("id") val id : Int,
    @Expose @SerializedName("login") val login : String,
    @Expose @SerializedName("haslo")val password : String,
    @Expose @SerializedName("nick")val nick : String,
    @Expose @SerializedName("numerTelefonu")val phoneNumber : Int,
    @Expose @SerializedName("email")val email : String
) {
    constructor(
        login: String,
        password: String,
        nick: String,
        phoneNumber: Int,
        email: String
    ) : this(0, login, password, nick, phoneNumber, email)
}