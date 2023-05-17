package com.moataz.masjed.ui.view.screens.masjeds

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.moataz.masjed.ui.view.screens.components.Loading
import com.moataz.masjed.ui.view.screens.components.MasjedItem
import com.moataz.masjed.ui.view.screens.components.MasjedToolbar
import com.moataz.masjed.ui.viewmodel.masjeds.MasjedViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MasjedsScreen(
    viewModel: MasjedViewModel = hiltViewModel(),
) {
    val masjedsUiState by viewModel.masjedsUiState.collectAsState()

    Scaffold(
        topBar = {
            MasjedToolbar(
                title = "Masjeds",
            )
        },
        content = {
            Box(modifier = Modifier.fillMaxSize()) {
                when {
                    masjedsUiState.isLoading -> Loading()

                    masjedsUiState.isSuccessful && masjedsUiState.masjeds.isNotEmpty() -> {
                        LazyColumn {
                            items(masjedsUiState.masjeds) { masjed ->
                                MasjedItem(masjed = masjed) {}
                            }
                        }
                    }

                    masjedsUiState.isError && masjedsUiState.masjeds.isEmpty() -> {
                        Snackbar(
                            modifier = Modifier
                                .padding(16.dp)
                                .align(Alignment.BottomEnd),
                            action = {
                                TextButton(onClick = viewModel::retryLoadMasjeds) {
                                    Text(
                                        text = "Retry",
                                        color = Color.White,
                                    )
                                }
                            },
                        ) {
                            Text(
                                text = "Failed to load MASJEDS",
                                color = Color.White,
                            )
                        }
                    }
                }

                FloatingActionButton(
                    onClick = { /* Handle click to navigate to "add masjed" screen */ },
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.BottomEnd)
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "Add Masjed")
                }
            }
        }
    )
}
