package com.moataz.masjed.ui.viewmodel.models

data class MasjedsUIState(
    val isLoading : Boolean = true,
    val isError : Boolean = false,
    val isSuccessful : Boolean = false,
    val masjeds : List<MasjedUI> = emptyList()
)
