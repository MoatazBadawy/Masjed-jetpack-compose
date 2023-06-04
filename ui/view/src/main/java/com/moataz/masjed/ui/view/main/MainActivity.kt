package com.moataz.masjed.ui.view.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import com.moataz.masjed.ui.view.screens.masjeds.MasjedsScreen
import com.moataz.masjed.ui.view.theme.MasjedJetpackComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MasjedsScreen()
        }
    }
}
