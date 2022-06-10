package com.example.unitconverter.data

import android.content.Context
import com.example.unitconverter.model.ConversionItem
import com.example.unitconverter.model.Currency
import com.google.gson.Gson

class ConversionData {
    companion object {
        val items = listOf(
            ConversionItem(
                1,
                "Length"
            ),
            ConversionItem(
                2,
                "Volume"
            ),
            ConversionItem(
                3,
                "Area"
            ),
            ConversionItem(
                4,
                "Mileage"
            ),
            ConversionItem(
                5,
                "Speed"
            ),
            ConversionItem(
                6,
                "Power"
            ),
            ConversionItem(
                7,
                "Pressure"
            ),
            ConversionItem(
                8,
                "Temperature"
            ),
            ConversionItem(
                9,
                "Time"
            ),
            ConversionItem(
                10,
                "Weight"
            ),
            ConversionItem(
                11,
                "Data"
            ),
            ConversionItem(
                12,
                "Currency"
            )
        )

    }
}


