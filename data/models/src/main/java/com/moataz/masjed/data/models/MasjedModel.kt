package com.moataz.masjed.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MASJED_TABLE")
data class MasjedModel(
    @PrimaryKey
    val masjedId: Int,
    val masjedName: String,
    val masjedDescription: String,
    val masjedImg: String,
    val masjedWorshipers: Int,
    val masjedImams: Int,
    val masjedWorkers: Int,
)
