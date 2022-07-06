package com.example.unitconverter.data

import android.content.Context
import com.example.unitconverter.model.Data
import com.example.unitconverter.model.Length
import com.google.gson.Gson

class LengthsDb {

    companion object {
        fun lengths (context: Context): List<Length> {
            val lengths = context.assets.open("lengths.json")
                .bufferedReader()
                .use {
                    it.readText()
                }
            return ArrayList(
                Gson().fromJson(
                    lengths,
                    Array<Length>::class.java
                ).toList()
            )
        }
    }
}