package com.example.unitconverter.data

import android.content.Context
import com.example.unitconverter.model.Length
import com.example.unitconverter.model.Pressures
import com.google.gson.Gson

class PressuresDb {

    companion object {
        fun pressures (context: Context): List<Pressures> {
            val pressure = context.assets.open("pressures.json")
                .bufferedReader()
                .use {
                    it.readText()
                }
            return ArrayList(
                Gson().fromJson(
                    pressure,
                    Array<Pressures>::class.java
                ).toList()
            )
        }
    }
}