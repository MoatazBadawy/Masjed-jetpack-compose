package com.moataz.masjed.ui.viewmodel.masjeds

import com.moataz.masjed.ui.viewmodel.models.MasjedUI

data class MasjedsUIState(
    val isLoading : Boolean = true,
    val isError : Boolean = false,
    val isSuccessful : Boolean = false,
    val masjeds : List<MasjedUI> = emptyList()
)
