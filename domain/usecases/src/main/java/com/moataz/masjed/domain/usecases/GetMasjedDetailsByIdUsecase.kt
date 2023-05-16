package com.moataz.masjed.domain.usecases

import com.moataz.masjed.domain.entities.Masjed
import com.moataz.masjed.domain.repository.MasjedLocalDatasource
import javax.inject.Inject

class GetMasjedDetailsByIdUsecase @Inject constructor(
    private val masjedLocalDataSource: MasjedLocalDatasource,
) {
    suspend operator fun invoke(masjedId: Int): Masjed {
        return masjedLocalDataSource.getMasjedDetailsById(masjedId)
    }
}
