package com.moataz.masjed.data.remote.response

data class BaseResponse<T>(
    val status: Boolean,
    val data: T,
    val message: String,
)
