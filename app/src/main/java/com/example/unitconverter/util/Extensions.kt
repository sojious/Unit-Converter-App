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



