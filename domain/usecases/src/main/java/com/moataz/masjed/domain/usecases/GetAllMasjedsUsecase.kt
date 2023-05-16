package com.moataz.masjed.domain.usecases

import com.moataz.masjed.domain.entities.Masjed
import com.moataz.masjed.domain.repository.MasjedLocalDatasource
import com.moataz.masjed.domain.repository.MasjedRemoteDatasource
import com.moataz.masjed.domain.usecases.utils.MasjedResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import java.net.UnknownHostException
import javax.inject.Inject

class GetAllMasjedsUsecase @Inject constructor(
    private val masjedRemoteDatasource: MasjedRemoteDatasource,
    private val masjedLocalDataSource: MasjedLocalDatasource,
) {
    suspend operator fun invoke(): Flow<MasjedResult> {
        return flow {
            emit(MasjedResult.Loading)
            emitAll(interactWithDatabase(masjedRemoteDatasource.getAllMasjeds()))
        }
    }

    private suspend fun interactWithDatabase(masjeds: List<Masjed>): Flow<MasjedResult> {
        return try {
            flow {
                if (masjeds.isNotEmpty()) {
                    masjedLocalDataSource.clearMasjedsCache()
                    masjeds.map { masjed ->
                        masjedLocalDataSource.insertMasjed(masjed)
                    }
                    emit(MasjedResult.Success(masjedLocalDataSource.getAllMasjeds()))
                } else {
                    emit(MasjedResult.EmptyResult)
                }
            }
        } catch (e: UnknownHostException) {
            flowOf(handleNoInternet(e))
        } catch (e: Exception) {
            flowOf(MasjedResult.Failure(e))
        }
    }

    private suspend fun handleNoInternet(e: UnknownHostException): MasjedResult {
        return if (masjedLocalDataSource.getAllMasjeds().isEmpty()) MasjedResult.Failure(e)
        else MasjedResult.NoInternet(masjedLocalDataSource.getAllMasjeds())
    }
}
