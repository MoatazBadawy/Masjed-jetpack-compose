package com.moataz.masjed.data.remote

import com.moataz.masjed.data.models.Masjed
import com.moataz.masjed.data.models.MasjedResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MasjedRemote {
    @GET("getMasjeds")
    suspend fun getAllMasjeds(): Response<MasjedResponse<List<Masjed>>>

    @GET("getMasjed/{id}")
    suspend fun getMasjedById(@Path("id") id: Int): Response<MasjedResponse<Masjed>>

    @POST("addNewMasjed")
    suspend fun addNewMasjed(@Body masjedDto: Masjed): Response<MasjedResponse<Masjed>>
}
