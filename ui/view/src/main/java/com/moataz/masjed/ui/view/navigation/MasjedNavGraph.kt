package com.moataz.masjed.ui.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.moataz.masjed.ui.view.screens.masjed_details.masjedDetailsRoute
import com.moataz.masjed.ui.view.screens.masjeds.masjedsRoute

@Composable
fun MasjedNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MasjedsScreen.route) {
        masjedsRoute(navController)
        masjedDetailsRoute(navController)
    }
}
