package com.moataz.masjed.ui.view.navigation

sealed class Screen(val route: String) {
    object MasjedsScreen : Screen("masjedsScreen")
}
