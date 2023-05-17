package com.moataz.masjed.ui.viewmodel.models

data class MasjedDetailsUIState(
    val isLoading : Boolean = true,
    val isError : Boolean = false,
    val isSuccessful : Boolean = false,
    val masjedDetailsUI : MasjedUI = MasjedUI()
)
