package com.example.syncauto.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun currentDestination(navController: NavHostController): String? {
    return navController.currentBackStackEntry?.destination?.route
}