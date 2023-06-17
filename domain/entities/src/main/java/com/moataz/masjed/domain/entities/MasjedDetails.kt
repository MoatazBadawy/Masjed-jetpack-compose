package com.moataz.masjed.domain.entities

data class MasjedDetails(
    val id: Int,
    val masjedId: Int,
    val name: String,
    val description: String,
    val imgUrl: String,
    val address: String,
    val siteArea: Int,
    val minarets: Int,
    val worshipers: Int,
    val imams: Int,
    val workers: Int,
    val gallery: List<Gallery>,
)
