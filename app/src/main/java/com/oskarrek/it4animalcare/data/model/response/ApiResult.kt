package com.oskarrek.it4animalcare.data.model.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ApiResult(
    @SerializedName("resultCode") val resultCode : Int,
    @SerializedName("message") val message : String)