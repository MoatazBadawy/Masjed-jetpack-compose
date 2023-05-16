package com.moataz.masjed.domain.repository

import com.moataz.masjed.domain.entities.Masjed

interface MasjedRemoteDatasource {
    suspend fun getAllMasjeds(): List<Masjed>
    suspend fun addNewMasjed(masjed: Masjed)
}
