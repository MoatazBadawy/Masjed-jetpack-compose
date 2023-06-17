package com.moataz.masjed.data.models.response

data class MasjedResponse<T>(
    val status: Boolean,
    val data: T,
    val message: String,
)
