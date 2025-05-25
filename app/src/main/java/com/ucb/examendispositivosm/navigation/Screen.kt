package com.ucb.examendispositivosm.navigation

sealed class Screen(val route: String) {
    object SubscriptionScreen : Screen("subscriptions")
    object MapScreen : Screen("map")
}

