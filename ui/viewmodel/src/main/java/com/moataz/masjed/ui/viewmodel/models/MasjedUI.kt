package com.moataz.masjed.ui.viewmodel.models

data class MasjedUI(
    val masjedId: Int = 0,
    val masjedName: String = "",
    val masjedDescription: String = "",
    val masjedImg: String = "",
    val masjedWorshipers: Int = 0,
    val masjedImams: Int = 0,
    val masjedWorkers: Int = 0,
)
