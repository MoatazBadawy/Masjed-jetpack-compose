package com.moataz.masjed.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.moataz.masjed.data.models.GalleryModel
import com.moataz.masjed.data.models.MasjedDetailsModel
import com.moataz.masjed.data.models.MasjedModel
import com.moataz.masjed.domain.entities.Gallery
import com.moataz.masjed.domain.entities.MasjedDetails

@Dao
interface MasjedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMasjed(masjedModel: MasjedModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMasjedDetails(masjedDetails: MasjedDetailsModel)

    @Query("DELETE FROM MASJED_TABLE")
    suspend fun deleteMasjeds()

    @Query("DELETE FROM MASJED_DETAILS_TABLE")
    suspend fun deleteMasjedDetails()

    @Query("SELECT * FROM MASJED_TABLE")
    suspend fun getALlMasjeds(): List<MasjedModel>

    @Query("SELECT * FROM MASJED_DETAILS_TABLE WHERE  masjedId = :masjedId")
    suspend fun getMasjedDetailsById(masjedId: Int): MasjedDetailsModel
}
