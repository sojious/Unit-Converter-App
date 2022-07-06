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
    Area("Area"),
    Volume("Volume"),
    Mileage("Mileage"),
    Speed("Speed"),
    Power("Power"),
    Pressure("Pressure"),
    Temperature("Temperature"),
    Time("Time"),
    Weight("Weight"),
    Data("Data")
}

@Parcelize
open class ConversionItem(
    open val id: Int,
    open val conversionName: String
) : Parcelable


interface ConversionUnit {
    val conversionName: String
    val rate: Double
}


@Parcelize
data class Currency(
    val id: Int,
    override val conversionName: String,
    val abbreviation: String,
    override val rate: Double
) : Parcelable, ConversionUnit

@Parcelize
data class Speed(
    val id: Int,
    override val conversionName: String,
    val abbreviation: String,
    override val rate: Double
) : Parcelable, ConversionUnit

@Parcelize
data class Temperature(
    val id: Int,
    override val conversionName: String,
    val abbreviation: String,
    override val rate: Double
) : Parcelable, ConversionUnit

@Parcelize
data class Time(
    val id: Int,
    override val conversionName: String,
    val abbreviation: String,
    override val rate: Double
) : Parcelable, ConversionUnit

@Parcelize
data class Volume(
    val id: Int,
    override val conversionName: String,
    val abbreviation: String,
    override val rate: Double
) : Parcelable, ConversionUnit


@Parcelize
data class Weight(
    val id: Int,
    override val conversionName: String,
    val abbreviation: String,
    override val rate: Double
) : Parcelable, ConversionUnit

@Parcelize
data class Area(
    val id: Int,
    override val conversionName: String,
    val abbreviation: String,
    override val rate: Double
) : Parcelable, ConversionUnit

@Parcelize
data class Power(
    val id: Int,
    override val conversionName: String,
    val abbreviation: String,
    override val rate: Double
) : Parcelable, ConversionUnit

@Parcelize
data class Data (
    val id: Int,
    override val conversionName: String,
    val abbreviation: String,
    override val rate: Double
) : Parcelable, ConversionUnit

@Parcelize
data class Length (
    val id: Int,
    override val conversionName: String,
    val abbreviation: String,
    override val rate: Double
) : Parcelable, ConversionUnit

@Parcelize
data class Mileages(
    val id: Int,
    override val conversionName: String,
    val abbreviation: String,
    override val rate: Double
) : Parcelable, ConversionUnit

@Parcelize
data class Pressures(
    val id: Int,
    override val conversionName: String,
    val abbreviation: String,
    override val rate: Double
) : Parcelable, ConversionUnit

