package com.example.unitconverter.data

import android.content.Context
import com.example.unitconverter.model.ConversionType
import com.example.unitconverter.model.ConversionUnit

class DataFactory {
    companion object {
        fun getData(
            context: Context,
            conversionName: String?
        ): List<ConversionUnit> {
            var units = listOf<ConversionUnit>()

            units = when (conversionName) {
                ConversionType.Currency.name -> {
                    CurrencyDb.currencies(context)
                }
                ConversionType.Length.name -> {
                    AreaDb.areas(context)
                }
                ConversionType.Area.name -> {
                    DataDB.data(context)
                }
                ConversionType.Volume.name -> {
                    VolumeDb.volumes(context)
                }
                ConversionType.Mileage.name -> {
                    MileagesDb.mileages(context)
                }
                ConversionType.Speed.name -> {
                    SpeedDb.speeds(context)
                }
                ConversionType.Power.name -> {

                    PowerDb.power(context)
                }
                ConversionType.Pressure.name -> {
                    PressuresDb.pressures(context)
                }
                ConversionType.Temperature.name -> {
                    TemperatureDb.temperatures(context)

                }
                ConversionType.Time.name -> {
                    TimeDb.times(context)
                }
                ConversionType.Weight.name -> {
                    WeightDb.weights(context)
                }
                ConversionType.Data.name -> {
                    DataDB.data(context)
                }
                else -> emptyList()
            }
            return units
        }
    }
}