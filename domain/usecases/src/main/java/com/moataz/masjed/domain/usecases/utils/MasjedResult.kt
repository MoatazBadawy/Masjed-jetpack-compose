package com.moataz.masjed.domain.usecases.utils

import com.moataz.masjed.domain.entities.Masjed

sealed class MasjedResult {
    object Loading : MasjedResult()
    object EmptyResult : MasjedResult()
    data class Success(val masjeds: List<Masjed>) : MasjedResult()
    data class Failure(val exception: Exception) : MasjedResult()
    data class NoInternet(val cachedMasjeds: List<Masjed>) : MasjedResult()
}
