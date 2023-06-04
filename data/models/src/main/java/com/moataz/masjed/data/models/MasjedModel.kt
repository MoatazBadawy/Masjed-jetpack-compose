package com.moataz.masjed.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MASJED_TABLE")
data class MasjedModel(
    @PrimaryKey
    val masjedId: Int? = null,
    val masjedName: String? = null,
    val masjedDescription: String? = null,
    val masjedImg: String? = null,
    val masjedWorshipers: Int? = null,
    val masjedImams: Int? = null,
    val masjedWorkers: Int? = null,
)
