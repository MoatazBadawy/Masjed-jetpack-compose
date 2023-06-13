package com.moataz.masjed.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.moataz.masjed.data.models.MasjedModel

@Dao
interface MasjedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMasjed(vararg masjedModel: MasjedModel)

    @Query("DELETE FROM MASJED_TABLE")
    suspend fun deleteMasjeds()

    @Query("SELECT * FROM MASJED_TABLE")
    suspend fun getALlMasjeds(): List<MasjedModel>

    @Query("SELECT * FROM MASJED_TABLE WHERE  id = :masjedId")
    suspend fun getMasjedDetailsById(masjedId: Int): MasjedModel
}
