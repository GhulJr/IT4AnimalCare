package com.oskarrek.it4animalcare.data.source.remote.api

import com.oskarrek.it4animalcare.data.model.request.RegisterRequest
import com.oskarrek.it4animalcare.data.model.response.GetAdvertisementsResponse
import com.oskarrek.it4animalcare.data.model.response.GetAnimalsResponse
import com.oskarrek.it4animalcare.data.model.response.GetDeadlinesResponse
import com.oskarrek.it4animalcare.data.model.response.RegisterResult
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AdvertisementsApi {

    @GET("/api/general/get_advertisement_info")
    fun getAdvertisements() : Single<GetAdvertisementsResponse>

    @GET("/api/general/get_deadline_of_advertisement/{id}")
    fun getAdvertisementDeadlines(@Path("id") id : Int) : Single<GetDeadlinesResponse>

    @GET("/api/general/get_animals_of_user/{id}")
    fun getAdvertisementAnimals(@Path("id") id : Int) : Single <GetAnimalsResponse>

    @POST("/api/logger/register")
    fun registerUser(@Body registerRequest: RegisterRequest) : Single<Response<RegisterResult>>
}