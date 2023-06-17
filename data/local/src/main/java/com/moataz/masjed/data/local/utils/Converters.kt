package com.moataz.masjed.data.local.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.moataz.masjed.data.models.GalleryModel

class Converters {

    @TypeConverter
    fun galleryListToJsonString(value: List<GalleryModel>?): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToGalleryList(value: String) =
        Gson().fromJson(value, Array<GalleryModel>::class.java).toList()
}
