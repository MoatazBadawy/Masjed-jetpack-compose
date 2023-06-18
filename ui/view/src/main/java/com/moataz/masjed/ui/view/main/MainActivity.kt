package com.moataz.masjed.ui.view.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.moataz.masjed.ui.view.navigation.MasjedNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MasjedNavGraph()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MasjedNavGraph()
}
