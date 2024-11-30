package com.example.syncauto


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.navigation.compose.rememberNavController
import com.example.syncauto.ui.navigation.BottomNavBar
import com.example.syncauto.ui.navigation.NavGraph
import com.example.syncauto.ui.navigation.Screen
import com.example.syncauto.ui.navigation.currentDestination
import com.example.syncauto.ui.splash.SplashScreen
import com.example.syncauto.ui.theme.SyncautoTheme
import kotlinx.coroutines.delay

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
    var showBottomBar by remember { mutableStateOf(false) } // Control visibility of bottom bar

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavBar(navController = navController)
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavGraph(
                navController = navController,
                onScreenChange = { screen ->
                    // Update bottom bar visibility based on the current screen
                    showBottomBar = screen != Screen.SplashScreen.route && screen != Screen.LoginScreen.route
                }
            )
        }
    }
}
