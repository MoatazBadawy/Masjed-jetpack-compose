package com.moataz.masjed.data.remote

import com.moataz.masjed.data.remote.dto.MasjedDto
import com.moataz.masjed.data.remote.response.BaseResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MasjedService {
    @GET("getMasjeds")
    suspend fun getAllMasjeds(): Response<BaseResponse<List<MasjedDto>>>

    @GET("getMasjed/{id}")
    suspend fun getMasjedById(@Path("id") id: Int): Response<BaseResponse<MasjedDto>>

    @POST("addNewMasjed")
    suspend fun addNewMasjed(@Body masjedDto: MasjedDto): Response<BaseResponse<MasjedDto>>
}
