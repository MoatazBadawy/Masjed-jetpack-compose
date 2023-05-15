package com.moataz.masjed.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.moataz.masjed.data.local.dao.MasjedDao
import com.moataz.masjed.data.local.entity.MasjedEntity

@Database(entities = [MasjedEntity::class], version = 1)
abstract class MasjedDatabase : RoomDatabase() {
    abstract fun masjedDao(): MasjedDao
}
