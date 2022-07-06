package com.example.unitconverter.data

import android.content.Context
import com.example.unitconverter.model.Data
import com.example.unitconverter.model.Mileages
import com.google.gson.Gson

class MileagesDb {
    companion object {
        fun mileages (context: Context): List<Mileages> {
            val mileages = context.assets.open("mileages.json")
                .bufferedReader()
                .use {
                    it.readText()
                }
            return ArrayList(
                Gson().fromJson(
                    mileages,
                    Array<Mileages>::class.java
                ).toList()
            )
        }
    }
}