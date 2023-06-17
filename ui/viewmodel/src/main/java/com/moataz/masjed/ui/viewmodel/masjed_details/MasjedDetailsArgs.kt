package com.moataz.masjed.ui.viewmodel.masjed_details

import androidx.lifecycle.SavedStateHandle

class MasjedDetailsArgs(savedStateHandle: SavedStateHandle) {

    val masjedId: Int = checkNotNull(savedStateHandle[MASJED_ID]).toString().toInt()

    companion object {
        const val MASJED_ID = "masjed_id"
    }
}
