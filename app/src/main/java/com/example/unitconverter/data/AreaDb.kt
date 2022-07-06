package com.example.unitconverter.data

import android.content.Context
import com.example.unitconverter.model.Area
import com.example.unitconverter.model.Power
import com.google.gson.Gson

class AreaDb {
    companion object {
        fun areas (context: Context): List<Area> {
            val area = context.assets.open("areas.json")
                .bufferedReader()
                .use {
                    it.readText()
                }
            return ArrayList(
                Gson().fromJson(
                    area,
                    Array<Area>::class.java
                ).toList()
            )
        }
    }
}