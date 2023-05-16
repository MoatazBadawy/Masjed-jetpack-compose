package com.moataz.masjed.domain.usecases

import com.moataz.masjed.domain.entities.Masjed
import com.moataz.masjed.domain.repository.MasjedRemoteDatasource
import javax.inject.Inject

class AddNewMasjedUsecase @Inject constructor(
    private val masjedRemoteDatasource: MasjedRemoteDatasource,
) {
    suspend operator fun invoke(masjed: Masjed) {
        masjedRemoteDatasource.addNewMasjed(masjed)
    }
}
