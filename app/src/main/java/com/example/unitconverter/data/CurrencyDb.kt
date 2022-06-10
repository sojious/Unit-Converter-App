package com.example.unitconverter.data

import android.content.Context
import com.example.unitconverter.model.Currency
import com.google.gson.Gson

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