package com.example.unitconverter.data

import android.content.Context
import com.example.unitconverter.model.Data
import com.example.unitconverter.model.Temperature
import com.google.gson.Gson

class TemperatureDb {
    companion object {
        fun temperatures (context: Context): List<Temperature> {
            val temperature = context.assets.open("temperatures.json")
                .bufferedReader()
                .use {
                    it.readText()
                }
            return ArrayList(
                Gson().fromJson(
                    temperature,
                    Array<Temperature>::class.java
                ).toList()
            )
        }
    }
}