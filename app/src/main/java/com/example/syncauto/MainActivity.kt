package com.example.syncauto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.syncauto.ui.splash.SplashScreen
import com.example.syncauto.ui.theme.SyncautoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SyncautoTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp(){
    var showSplash by remember { mutableStateOf(true) }
    if (showSplash){
        SplashScreen {
            showSplash = true
        }
    }else {

    }
}

