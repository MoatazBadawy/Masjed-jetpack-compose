package com.moataz.masjed.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.moataz.masjed.data.local.utils.Converters
import com.moataz.masjed.data.models.GalleryModel
import com.moataz.masjed.data.models.MasjedDetailsModel
import com.moataz.masjed.data.models.MasjedModel

@Database(
    entities = [MasjedModel::class,
        MasjedDetailsModel::class,
        GalleryModel::class
    ],
    version = 1
)
@TypeConverters(Converters::class)
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
