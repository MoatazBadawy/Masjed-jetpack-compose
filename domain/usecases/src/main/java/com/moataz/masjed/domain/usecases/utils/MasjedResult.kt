package com.moataz.masjed.domain.usecases.utils

sealed class MasjedResult<T> {
    data class Success<T>(val data: T) : MasjedResult<T>()
    data class Failure<T>(val exception: Exception) : MasjedResult<T>()
    data class NoInternet<T>(val cashedData: T) : MasjedResult<T>()
    data class EmptyResult<T>(val emptyResult: T? = null) : MasjedResult<T>()
    data class Loading<T>(val data: T? = null) : MasjedResult<T>()
}
