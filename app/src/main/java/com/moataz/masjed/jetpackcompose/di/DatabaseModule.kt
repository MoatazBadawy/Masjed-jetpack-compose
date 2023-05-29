package com.moataz.masjed.jetpackcompose.di

import android.content.Context
import com.moataz.masjed.data.local.MasjedDao
import com.moataz.masjed.data.local.MasjedDatabase
import com.moataz.masjed.data.local.MasjedLocalFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext appContext: Context
    ): MasjedDatabase {
        return MasjedLocalFactory.roomDatabase(appContext)
    }

    @Singleton
    @Provides
    fun provideMasjedDao(database: MasjedDatabase): MasjedDao {
        return database.masjedDao()
    }
}
