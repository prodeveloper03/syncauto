package com.example.syncauto.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.syncauto.ui.history.HistoryScreen
import com.example.syncauto.ui.home.HomeScreen
import com.example.syncauto.ui.login.LoginScreen
import com.example.syncauto.ui.splash.SplashScreen

sealed class Screen(val route: String, val title: String) {
    object SplashScreen : Screen("splash","SplashScreen")
    object LoginScreen : Screen("login","LoginScreen")
    object Home : Screen("home", "Home")
    object History : Screen("history", "History")

}

@Composable
fun NavGraph(
    navController: NavHostController,
    onScreenChange: (String) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(Screen.SplashScreen.route) {
            onScreenChange(Screen.SplashScreen.route)
            SplashScreen(
                onNavigateToLogin = {
                    navController.navigate(Screen.LoginScreen.route) {
                        popUpTo(Screen.SplashScreen.route) { inclusive = true }
                    }
                },
                onSplashEnd = { /* Handle splash end (optional) */ }
            )
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(
                onLoginClick = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.LoginScreen.route) { inclusive = true }
                    }
                },
                onSignUpClick = {

                }
            )
        }
        composable(Screen.Home.route) {
            HomeScreen()
        }
        composable(Screen.History.route) {
            HistoryScreen()
        }
    }
}
