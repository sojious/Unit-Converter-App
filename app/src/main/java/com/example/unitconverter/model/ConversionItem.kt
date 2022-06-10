package com.example.unitconverter.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * TODO: Please do well to ensure you subclass ConversionItem for
 * conversion units, thank you!!!
 */

enum class ConversionType(type: String) {
    Currency("Currency"),
    Length("Length"),
    Area("Area")
    //todo add more units
}

@Parcelize
open class ConversionItem(
    open val id: Int,
    open val conversionName: String
) : Parcelable


interface ConversionUnit {
    val conversionName: String
}


@Parcelize
data class Currency(
    val id: Int,
    override val conversionName: String,
    val abbreviation: String,
    val rateInUsd: Double
) : Parcelable, ConversionUnit


