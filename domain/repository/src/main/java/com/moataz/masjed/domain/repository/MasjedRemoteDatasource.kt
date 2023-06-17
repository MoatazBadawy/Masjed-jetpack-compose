package com.moataz.masjed.domain.repository

import com.moataz.masjed.domain.entities.Masjed
import com.moataz.masjed.domain.entities.MasjedDetails

interface MasjedRemoteDatasource {
    suspend fun getAllMasjeds(): List<Masjed>
    suspend fun getMasjedDetails(masjedId: Int): MasjedDetails
    suspend fun addNewMasjed(masjed: Masjed)
}
