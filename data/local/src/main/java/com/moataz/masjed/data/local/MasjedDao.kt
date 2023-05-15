package com.moataz.masjed.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.moataz.masjed.data.models.Masjed

@Dao
interface MasjedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMasjed(masjed: Masjed)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMasjedDetails(masjed: Masjed)

    @Query("DELETE FROM MASJED_TABLE")
    suspend fun deleteMasjeds()

    @Query("SELECT * FROM MASJED_TABLE")
    suspend fun getMasjeds(): List<Masjed>

    @Query("SELECT * FROM MASJED_TABLE WHERE  masjedId = :masjedId")
    suspend fun getMasjedDetailsById(masjedId: Int): Masjed
}
