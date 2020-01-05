package com.oskarrek.it4animalcare.data.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

data class CareModel(
    val id: Int,
    val animals: MutableList<AnimalModel>
) {
    constructor(animals: MutableList<AnimalModel>) : this(0, animals)

    //TODO: Rewrite this to work with older Android versions.
    override fun toString(): String = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val joiner = StringJoiner(",")
            for (animal in animals) {
                joiner.add(animal.species)
            }
            joiner.toString()
        } else {
            animals[0].species
        }

}