package com.moataz.masjed.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MASJED_DETAILS_TABLE")
data class MasjedDetailsModel(
    @PrimaryKey
    val id: Int = 0,
    val masjedId: Int? = null,
    val name: String? = null,
    val description: String? = null,
    val imgUrl: String? = null,
    val address: String? = null,
    val siteArea: Int? = null,
    val minarets: Int? = null,
    val worshipers: Int? = null,
    val imams: Int? = null,
    val workers: Int? = null,
    val gallery: List<GalleryModel> = emptyList(),
)
