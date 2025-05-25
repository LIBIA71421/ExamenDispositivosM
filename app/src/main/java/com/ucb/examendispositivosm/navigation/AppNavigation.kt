package com.ucb.examendispositivosm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ucb.examendispositivosm.map.MapScreenUI
import com.ucb.examendispositivosm.subscription.SubscriptionUI

@Composable
fun AppNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.SubscriptionScreen.route
    ) {
        composable(Screen.SubscriptionScreen.route) {
            SubscriptionUI(navController = navController)
        }
        composable(Screen.MapScreen.route) {
            MapScreenUI()
        }

    }
}
