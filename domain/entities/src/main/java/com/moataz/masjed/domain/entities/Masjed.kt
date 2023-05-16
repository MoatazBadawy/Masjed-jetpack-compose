package com.moataz.masjed.domain.entities

data class Masjed(
    val masjedId: Int,
    val masjedName: String,
    val masjedDescription: String,
    val masjedImg: String,
    val masjedWorshipers: Int,
    val masjedImams: Int,
    val masjedWorkers: Int,
)
