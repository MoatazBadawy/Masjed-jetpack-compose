package com.moataz.masjed.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MASJED_GALLERY_TABLE")
data class GalleryModel(
    @PrimaryKey
    val id: Int = 0,
    val masjedId: Int? = null,
    val imgUrl: String? = null,
)
