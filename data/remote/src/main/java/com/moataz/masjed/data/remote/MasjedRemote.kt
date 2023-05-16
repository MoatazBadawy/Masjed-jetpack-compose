package com.moataz.masjed.data.remote

import com.moataz.masjed.data.models.MasjedModel
import com.moataz.masjed.data.models.MasjedResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MasjedRemote {
    @GET("getMasjeds")
    suspend fun getAllMasjeds(): Response<MasjedResponse<List<MasjedModel>>>

    @GET("getMasjed/{id}")
    suspend fun getMasjedById(@Path("id") id: Int): Response<MasjedResponse<MasjedModel>>

    @POST("addNewMasjed")
    suspend fun addNewMasjed(@Body masjedModelDto: MasjedModel): Response<MasjedResponse<MasjedModel>>
}
