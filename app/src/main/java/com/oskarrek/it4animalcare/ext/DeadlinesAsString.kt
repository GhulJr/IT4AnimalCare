package com.oskarrek.it4animalcare.ext

import android.os.Build
import com.oskarrek.it4animalcare.data.model.DeadlineModel
import java.text.SimpleDateFormat
import java.util.*

fun Long.asDate(format : String) : String = SimpleDateFormat(format).format(Date(this))

fun List<DeadlineModel>.asString() : String =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
    val joiner = StringJoiner(", ")
    for (deadline in this) {
        joiner.add(deadline.timeInMillis.asDate("dd.MM.yy"))
    }
    joiner.toString()
} else {
    this[0].timeInMillis.asDate("dd.MM.yy")
}