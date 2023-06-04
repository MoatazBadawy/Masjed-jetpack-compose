package com.moataz.masjed.data.local.datasource

import com.moataz.masjed.data.local.MasjedDao
import com.moataz.masjed.data.models.mapper.toMasjed
import com.moataz.masjed.data.models.mapper.toMasjedModel
import com.moataz.masjed.data.models.mapper.toMasjeds
import com.moataz.masjed.domain.entities.Masjed
import com.moataz.masjed.domain.repository.MasjedLocalDatasource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MasjedLocalDatasourceImpl @Inject constructor(
    private val masjedDao: MasjedDao,
) : MasjedLocalDatasource {
    override suspend fun getAllMasjeds(): List<Masjed> {
        return withContext(Dispatchers.IO) {
            masjedDao.getALlMasjeds().toMasjeds()
        }
    }

    override suspend fun getMasjedDetailsById(masjedId: Int): Masjed {
        return withContext(Dispatchers.IO) {
            masjedDao.getMasjedDetailsById(masjedId).toMasjed()
        }
    }

    override suspend fun insertMasjed(masjed: Masjed) {
        withContext(Dispatchers.IO) {
            masjedDao.insertMasjed(masjed.toMasjedModel())
        }
    }

    override suspend fun clearMasjedsCache() {
        withContext(Dispatchers.IO) {
            masjedDao.deleteMasjeds()
        }
    }
}
