package com.oskarrek.it4animalcare.util

import com.oskarrek.it4animalcare.data.model.*
import java.util.*

object DummyDataUtils {
    fun getDummyAdvertisements() : List<AdvertisementModel>{
        val advertisements = mutableListOf<AdvertisementModel>()
        for(i in 0..19 ) {

            val deadlines = mutableListOf(
                DeadlineModel(1578226817798),
                DeadlineModel(1578226818798))

            val care = CareModel(mutableListOf(
                AnimalModel(
                "Azor",
                "Pies",
                6,
                false),
                AnimalModel(
                    "Waldek",
                    "Kot",
                    8,
                    false
                )))

            val localisation = LocalisationModel("Bielsko-Biala", "43-400")

            val advertisement =  AdvertisementModel(
                "Piesek i kotek szukają opiekuna na nadchodzące święta!",
                "Piesek i kotek szukają opiekuna na nadchodzące święta!" +
                        "Piesek i kotek szukają opiekuna na nadchodzące święta!" +
                        "Piesek i kotek szukają opiekuna na nadchodzące święta!" +
                        "Piesek i kotek szukają opiekuna na nadchodzące święta!" +
                        "Piesek i kotek szukają opiekuna na nadchodzące święta!" +
                        "Piesek i kotek szukają opiekuna na nadchodzące święta!",
                Calendar.getInstance().timeInMillis,
                Calendar.getInstance().timeInMillis + 10000,
                localisation)

            advertisements.add(advertisement)
        }
        return advertisements
    }
}