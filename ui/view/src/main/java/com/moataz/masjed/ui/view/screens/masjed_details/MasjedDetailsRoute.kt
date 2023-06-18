package com.moataz.masjed.ui.view.screens.masjed_details

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.moataz.masjed.ui.viewmodel.masjed_details.MasjedDetailsArgs

const val MASJED_DETAILS_SCREEN = "masjedDetailsScreenWithId"

fun NavController.navigateToMasjedDetails(masjedId: Int) {
    navigate("$MASJED_DETAILS_SCREEN/$masjedId")
}

fun NavGraphBuilder.masjedDetailsRoute(navController: NavController) {
    composable(
        route = "$MASJED_DETAILS_SCREEN/{${MasjedDetailsArgs.MASJED_ID}}",
        arguments = listOf(
            navArgument(MasjedDetailsArgs.MASJED_ID) { NavType.IntType },
        ),
    ) {
        MasjedDetailsScreen(navController)
    }
}
