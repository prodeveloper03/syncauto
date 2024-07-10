package com.example.syncauto

import android.os.Build
import android.os.Bundle
import android.view.Window
import android.widget.EdgeEffect
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.example.syncauto.ui.navigation.BottomNavBar
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
fun MyApp() {
    val navController = rememberNavController()
    var showSplash by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(2000L) // 2 seconds
        showSplash = false
    }

    if (showSplash) {
        SplashScreen()
    } else {
        Scaffold(
            bottomBar = { BottomNavBar(navController = navController) }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
               com.example.syncauto.ui.navigation.NavGraph(navController = navController)
            }
        }
    }
}

