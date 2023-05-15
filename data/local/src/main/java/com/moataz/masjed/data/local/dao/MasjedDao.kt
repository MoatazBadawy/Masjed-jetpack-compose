package com.moataz.masjed.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.moataz.masjed.data.local.entity.MasjedEntity

@Dao
interface MasjedDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMasjed(masjed: MasjedEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMasjedDetails(masjed: MasjedEntity)

    @Query("DELETE FROM MASJED_TABLE")
    suspend fun deleteMasjeds()

    @Query("SELECT * FROM MASJED_TABLE")
    suspend fun getMasjeds(): List<MasjedEntity>

    @Query("SELECT * FROM MASJED_TABLE WHERE  masjedId = :masjedId")
    suspend fun getMasjedDetailsById(masjedId: Int): MasjedEntity
}
