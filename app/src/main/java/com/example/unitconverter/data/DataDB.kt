package com.example.unitconverter.data

import android.content.Context
import com.example.unitconverter.model.Area
import com.example.unitconverter.model.Data
import com.google.gson.Gson

class DataDB {
    companion object {
        fun data (context: Context): List<Data> {
            val data = context.assets.open("datas.json")
                .bufferedReader()
                .use {
                    it.readText()
                }
            return ArrayList(
                Gson().fromJson(
                    data,
                    Array<Data>::class.java
                ).toList()
            )
        }
    }
}