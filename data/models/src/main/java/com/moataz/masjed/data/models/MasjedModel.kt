package com.moataz.masjed.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MASJED_TABLE")
data class MasjedModel(
    @PrimaryKey
    val id: Int? = null,
    val name: String? = null,
    val description: String? = null,
    val imgUrl: String? = null,
)
