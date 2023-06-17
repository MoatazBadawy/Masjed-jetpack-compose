package com.moataz.masjed.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MASJED_TABLE")
data class MasjedModel(
    @PrimaryKey
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val imgUrl: String = "",
)
