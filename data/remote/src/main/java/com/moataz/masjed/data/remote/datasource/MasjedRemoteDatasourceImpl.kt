package com.moataz.masjed.data.remote.datasource

import com.moataz.masjed.data.models.mapper.toMasjedDetails
import com.moataz.masjed.data.models.mapper.toMasjedModel
import com.moataz.masjed.data.models.mapper.toMasjeds
import com.moataz.masjed.data.remote.MasjedRemote
import com.moataz.masjed.domain.entities.Masjed
import com.moataz.masjed.domain.entities.MasjedDetails
import com.moataz.masjed.domain.repository.MasjedRemoteDatasource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MasjedRemoteDatasourceImpl @Inject constructor(
    private val masjedRemote: MasjedRemote,
) : MasjedRemoteDatasource {
    override suspend fun getAllMasjeds(): List<Masjed> {
        return withContext(Dispatchers.IO) {
            wrap { masjedRemote.getAllMasjeds() }.toMasjeds()
        }
    }

    override suspend fun getMasjedDetails(masjedId: Int): MasjedDetails {
        return withContext(Dispatchers.IO) {
            wrap { masjedRemote.getMasjedDetailsById(masjedId) }.toMasjedDetails()
        }
    }

    override suspend fun addNewMasjed(masjed: Masjed) {
        masjedRemote.addNewMasjed(masjed.toMasjedModel())
    }
}
