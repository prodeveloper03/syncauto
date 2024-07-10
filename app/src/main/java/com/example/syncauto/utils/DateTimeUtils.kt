package com.example.syncauto.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun getCurrentTime(): String {
    val time =  Date()
    val formatter = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    return formatter.format(time)
}

fun getCurrentDate() : String {
    val date = Date()
    val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    return formatter.format(date)
}