package com.moataz.masjed.ui.viewmodel.masjed_details

import com.moataz.masjed.ui.viewmodel.models.MasjedDetailsUI

data class MasjedDetailsUIState(
    val masjedDetails: MasjedDetailsUI = MasjedDetailsUI(),
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val isSuccess: Boolean = false,
)
