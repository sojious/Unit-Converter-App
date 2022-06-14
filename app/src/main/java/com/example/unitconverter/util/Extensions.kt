package com.example.unitconverter.util

import android.content.Context
import android.util.TypedValue
import com.example.unitconverter.model.ConversionUnit
import com.example.unitconverter.model.Currency
import kotlin.math.roundToInt

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

fun Double.convert(from: ConversionUnit, to: ConversionUnit): Double {
    val isValid = from::class == to::class
    if (isValid) {
        return this * (to.rate / from.rate)
    }
    return 0.0
}

fun String.convert(from: ConversionUnit, to: ConversionUnit): String {
    return this.toDouble().convert(from, to).toString()
}

fun Double.roundOff(): Double {
    return (this * 10000.0).roundToInt() / 10000.0
}
