package com.moataz.masjed.ui.view.screens.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moataz.masjed.ui.view.theme.Background

@Composable
fun MasjedToolbar(
    title: String,
) {
    TopAppBar(
        title = { Text(text = title, color = Color.Black,) },
        backgroundColor = Background,
        elevation = 4.dp,
    )
}
