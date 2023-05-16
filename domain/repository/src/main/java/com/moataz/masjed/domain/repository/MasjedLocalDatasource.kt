package com.moataz.masjed.domain.repository

import com.moataz.masjed.domain.entities.Masjed

interface MasjedLocalDatasource {
    suspend fun getAllMasjeds(): List<Masjed>
    suspend fun getMasjedDetailsById(masjedId: Int): Masjed
    suspend fun insertMasjed(masjed: Masjed)
    suspend fun clearMasjedsCache()
}
