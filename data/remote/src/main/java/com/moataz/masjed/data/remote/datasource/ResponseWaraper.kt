package com.moataz.masjed.data.remote.datasource

import com.moataz.masjed.data.models.response.MasjedResponse
import retrofit2.Response
import java.io.IOException

suspend fun <T : Any> wrap(function: suspend () -> Response<MasjedResponse<T>>): T {
    return try {
        val response = function()
        when {
            response.isSuccessful -> {
                response.body()?.data ?: throw Exception("Response body is null")
            }

            else -> {
                throw Exception("Response is not successful")
            }
        }
    } catch (e: IOException) {
        throw Exception("Network error", e)
    } catch (e: Exception) {
        throw Exception("Unknown error", e)
    }
}
