package com.example.unitconverter.util

import android.content.Context
import android.util.TypedValue
import com.example.unitconverter.model.ConversionUnit
import com.example.unitconverter.model.Currency

fun Double.secondToMillisecond(): Long {
    return (this * 1000).toLong()
}

fun Float.toDp(context: Context): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        context.resources.displayMetrics
    )
}

fun List<ConversionUnit>.getConversionNames(): List<String> {
    val names = mutableListOf<String>()
    this.forEach {
        names.add(it.conversionName)
    }
    return names.toList()
}


fun Double.convert(from: ConversionUnit, to: ConversionUnit): Double? {
    val isValid = from::class == to::class
    if (isValid) {
        return this * (to.rate / from.rate)
    }
    return null
}
