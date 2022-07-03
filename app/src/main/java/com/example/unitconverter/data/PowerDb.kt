package com.example.unitconverter.data

import android.content.Context
import com.example.unitconverter.model.Power
import com.google.gson.Gson

class PowerDb {
    companion object {
        fun power (context: Context): List<Power> {
            val powers = context.assets.open("powers.json")
                .bufferedReader()
                .use {
                    it.readText()
                }
            return ArrayList(
                Gson().fromJson(
                    powers,
                    Array<Power>::class.java
                ).toList()
            )
        }
    }
}