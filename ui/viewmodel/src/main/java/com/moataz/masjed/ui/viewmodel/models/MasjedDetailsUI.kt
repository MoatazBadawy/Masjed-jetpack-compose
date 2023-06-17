package com.moataz.masjed.ui.viewmodel.models

data class MasjedDetailsUI(
    val id: Int = 0,
    val masjedId: Int = 0,
    val name: String = "",
    val description: String = "",
    val imgUrl: String = "",
    val address: String = "",
    val siteArea: Int = 0,
    val minarets: Int = 0,
    val worshipers: Int = 0,
    val imams: Int = 0,
    val workers: Int = 0,
    val gallery: List<GalleryUI> = emptyList(),
)
