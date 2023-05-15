package com.moataz.masjed.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.moataz.masjed.data.local.entity.utils.EntityConstant.MASJED_TABLE

@Entity(tableName = MASJED_TABLE)
data class MasjedEntity(
    @PrimaryKey
    val masjedId: Int,
    val masjedName: String,
    val masjedDescription: String,
    val masjedImg: String,
    val masjedWorshipers: Int,
    val masjedImams: Int,
    val masjedWorkers: Int,
)
