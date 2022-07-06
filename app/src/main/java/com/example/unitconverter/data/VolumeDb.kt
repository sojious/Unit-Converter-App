package com.example.unitconverter.data

import android.content.Context
import com.example.unitconverter.model.Volume
import com.google.gson.Gson

class VolumeDb {

    companion object {
        fun volumes (context: Context): List<Volume> {
            val volume = context.assets.open("volumes.json")
                .bufferedReader()
                .use {
                    it.readText()
                }
            return ArrayList(
                Gson().fromJson(
                    volume,
                    Array<Volume>::class.java
                ).toList()
            )
        }
    }
}