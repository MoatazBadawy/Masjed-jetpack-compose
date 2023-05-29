package com.moataz.masjed.jetpackcompose.di

import com.moataz.masjed.data.remote.MasjedRemote
import com.moataz.masjed.data.remote.MasjedRemoteFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideMasjedRemoteAPI(
        client: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
    ): MasjedRemote {
        return MasjedRemoteFactory.masjedRemoteApi({ client }, gsonConverterFactory)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return MasjedRemoteFactory.okHttpClient()
    }

    @Singleton
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return MasjedRemoteFactory.gsonConverterFactory()
    }
}
