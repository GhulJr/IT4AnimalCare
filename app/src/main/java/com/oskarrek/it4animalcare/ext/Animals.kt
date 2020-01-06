package com.oskarrek.it4animalcare.ext

import com.oskarrek.it4animalcare.R
import com.oskarrek.it4animalcare.data.model.AnimalModel

fun AnimalModel.getSex() : Int{
    return when(sex) {
        false -> R.string.sex_women
        true -> R.string.sex_women
        else -> R.string.sex_unknown
    }
}