package com.example.unitconverter.data

import android.content.Context
import com.example.unitconverter.model.Data
import com.example.unitconverter.model.Time
import com.google.gson.Gson

class TimeDb {

    companion object {
        fun times (context: Context): List<Time> {
            val time = context.assets.open("times.json")
                .bufferedReader()
                .use {
                    it.readText()
                }
            return ArrayList(
                Gson().fromJson(
                    time,
                    Array<Time>::class.java
                ).toList()
            )
        }
    }
}