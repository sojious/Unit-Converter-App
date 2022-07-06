package com.example.unitconverter.data

import android.content.Context
import com.example.unitconverter.model.Data
import com.example.unitconverter.model.Weight
import com.google.gson.Gson

class WeightDb {

    companion object {
        fun weights (context: Context): List<Weight> {
            val weights = context.assets.open("weights.json")
                .bufferedReader()
                .use {
                    it.readText()
                }
            return ArrayList(
                Gson().fromJson(
                    weights,
                    Array<Weight>::class.java
                ).toList()
            )
        }
    }
}