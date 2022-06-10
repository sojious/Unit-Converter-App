package com.example.unitconverter.util

fun Double.secondToMillisecond(): Long {
    return (this * 1000).toLong()
}