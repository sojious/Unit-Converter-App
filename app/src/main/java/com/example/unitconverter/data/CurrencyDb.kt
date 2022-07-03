package com.example.unitconverter.data

import android.content.Context
import com.example.unitconverter.model.Currency
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CurrencyDb {
    companion object {
        fun currencies(context: Context): List<Currency> {
            val currencies = context.assets.open("currencies.json")
                .bufferedReader()
                .use {
                    it.readText()
                }
            return ArrayList(
                Gson().fromJson(
                    currencies,
                    Array<Currency>::class.java
                ).toList()
            )

        }
    }

}

//TODO Please, populate the other JSON files already created in the assets folder.