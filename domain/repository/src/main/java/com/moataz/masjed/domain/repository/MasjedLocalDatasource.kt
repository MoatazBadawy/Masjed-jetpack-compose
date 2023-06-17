package com.moataz.masjed.domain.repository

import com.moataz.masjed.domain.entities.Gallery
import com.moataz.masjed.domain.entities.Masjed
import com.moataz.masjed.domain.entities.MasjedDetails

interface MasjedLocalDatasource {
    suspend fun getAllMasjeds(): List<Masjed>
    suspend fun getMasjedDetailsById(masjedId: Int): MasjedDetails
    suspend fun insertMasjed(masjed: Masjed)
    suspend fun insertMasjedDetails(masjedDetails: MasjedDetails)
    suspend fun clearMasjedsCache()
    suspend fun clearMasjedDetailsCache()
}
