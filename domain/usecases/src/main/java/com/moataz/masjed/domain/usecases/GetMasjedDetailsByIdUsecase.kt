package com.moataz.masjed.domain.usecases

import com.moataz.masjed.domain.entities.MasjedDetails
import com.moataz.masjed.domain.repository.MasjedLocalDatasource
import com.moataz.masjed.domain.repository.MasjedRemoteDatasource
import com.moataz.masjed.domain.usecases.utils.MasjedResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import java.net.UnknownHostException
import javax.inject.Inject

class GetMasjedDetailsByIdUsecase @Inject constructor(
    private val masjedRemoteDatasource: MasjedRemoteDatasource,
    private val masjedLocalDataSource: MasjedLocalDatasource,
) {
    suspend operator fun invoke(masjedId: Int): Flow<MasjedResult<MasjedDetails>> {
        return flow {
            emit(MasjedResult.Loading())
            val localData = masjedLocalDataSource.getMasjedDetailsById(masjedId)

            emit(MasjedResult.Success(localData))

            try {
                val remoteData = masjedRemoteDatasource.getMasjedDetails(masjedId)
                emitAll(interactWithDatabase(remoteData))
            } catch (e: UnknownHostException) {
                emit(MasjedResult.NoInternet(localData))
            } catch (e: Exception) {
                emit(MasjedResult.Failure(e))
            }
        }
    }

    private suspend fun interactWithDatabase(masjedDetails: MasjedDetails): Flow<MasjedResult<MasjedDetails>> {
        return try {
            flow {
                masjedLocalDataSource.clearMasjedDetailsCache()
                masjedLocalDataSource.insertMasjedDetails(masjedDetails)
                emit(MasjedResult.Success(masjedLocalDataSource.getMasjedDetailsById(masjedDetails.id)))
            }
        } catch (e: Exception) {
            flowOf(MasjedResult.Failure(e))
        }
    }
}
