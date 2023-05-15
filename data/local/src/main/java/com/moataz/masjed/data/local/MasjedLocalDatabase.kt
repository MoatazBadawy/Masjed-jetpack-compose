package com.moataz.masjed.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.moataz.masjed.data.models.Masjed

@Database(entities = [Masjed::class], version = 1)
abstract class MasjedDatabase : RoomDatabase() {
    abstract fun masjedDao(): MasjedDao
}

object MasjedLocalFactory {
    fun roomDatabase(context: Context) = Room.databaseBuilder(
        context,
        MasjedDatabase::class.java,
        "masjed-database",
    ).build()
}
