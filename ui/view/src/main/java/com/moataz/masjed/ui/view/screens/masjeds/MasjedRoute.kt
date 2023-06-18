package com.moataz.masjed.ui.view.screens.masjeds

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.moataz.masjed.ui.view.navigation.Screen

fun NavGraphBuilder.masjedsRoute(navController: NavController) {
    composable(route = Screen.MasjedsScreen.route) {
        MasjedsScreen(navController)
    }
}
