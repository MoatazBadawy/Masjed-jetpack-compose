package com.moataz.masjed.data.remote

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

object MasjedRemoteFactory {

    fun okHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            readTimeout(25, TimeUnit.SECONDS)
            connectTimeout(25, TimeUnit.SECONDS)
        }.build()
    }

    fun masjedRemoteApi(client: () -> OkHttpClient): MasjedRemote {
        return Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(client())
            .build()
            .create(MasjedRemote::class.java)
    }
}
