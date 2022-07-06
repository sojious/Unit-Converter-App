package com.example.unitconverter.data

import android.content.Context
import com.example.unitconverter.model.Data
import com.example.unitconverter.model.Speed
import com.google.gson.Gson

class SpeedDb {
    companion object {
        fun speeds (context: Context): List<Speed> {
            val speed = context.assets.open("speeds.json")
                .bufferedReader()
                .use {
                    it.readText()
                }
            return ArrayList(
                Gson().fromJson(
                    speed,
                    Array<Speed>::class.java
                ).toList()
            )
        }
    }
}