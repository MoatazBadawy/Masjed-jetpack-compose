package com.moataz.masjed.data.remote.dto

data class MasjedDto(
    val masjedId: Int,
    val masjedName: String,
    val masjedDescription: String,
    val masjedImg: String,
    val masjedWorshipers: Int,
    val masjedImams: Int,
    val masjedWorkers: Int,
)
