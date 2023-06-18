package com.moataz.masjed.ui.view.screens.masjeds

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.moataz.masjed.ui.view.screens.components.Loading
import com.moataz.masjed.ui.view.screens.components.MasjedItem
import com.moataz.masjed.ui.view.screens.components.MasjedToolbar
import com.moataz.masjed.ui.view.screens.masjed_details.navigateToMasjedDetails
import com.moataz.masjed.ui.viewmodel.masjeds.MasjedViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MasjedsScreen(
    navController: NavController,
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
                SwipeRefresh(
                    state = rememberSwipeRefreshState(isRefreshing = false),
                    onRefresh = { viewModel.retryLoadMasjeds() },
                ) {
                    if (masjedsUiState.isLoading) {
                        Loading()
                    }
                    LazyColumn {
                        items(masjedsUiState.masjeds) { masjed ->
                            MasjedItem(
                                masjed = masjed,
                                onButtonClick = {
                                    navController.navigateToMasjedDetails(masjed.id)
                                }
                            )
                        }
                    }
                }
            }
        }
    )
}
