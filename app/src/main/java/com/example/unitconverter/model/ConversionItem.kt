package com.example.unitconverter.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ConversionItem(
    val id: Int,
    val conversionName: String
): Parcelable