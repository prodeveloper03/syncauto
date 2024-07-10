package com.example.syncauto.ui.home

import android.os.Build
import androidx.activity.compose.LocalActivityResultRegistryOwner.current
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.syncauto.utils.getCurrentDate
import com.example.syncauto.utils.getCurrentTime
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Formatter
import java.util.Locale


@Composable
@Preview
fun HomeScreen() {

    // Global State

    var currentTime by remember { mutableStateOf(getCurrentTime()) }
    var currentDate by remember { mutableStateOf(getCurrentDate()) }


    LaunchedEffect(Unit) {

        while (true){
            currentTime = getCurrentTime()
            delay(1000L)
        }
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start

    ){
        Text(text = "$currentTime / $currentDate" , style = MaterialTheme.typography.bodyMedium)
    }
}


