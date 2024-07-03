package com.example.syncauto.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.syncauto.ui.history.HistoryScreen
import com.example.syncauto.ui.home.HomeScreen

sealed class Screen(val route: String, val title: String) {
    object Home : Screen("home", "Home")
    object History : Screen("history", "History")
}

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String = Screen.Home.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.Home.route) {
            HomeScreen()
        }
        composable(Screen.History.route) {
            HistoryScreen()
        }
    }
}