package com.moataz.masjed.jetpackcompose.di

import com.moataz.masjed.data.local.datasource.MasjedLocalDatasourceImpl
import com.moataz.masjed.data.remote.datasource.MasjedRemoteDatasourceImpl
import com.moataz.masjed.domain.repository.MasjedLocalDatasource
import com.moataz.masjed.domain.repository.MasjedRemoteDatasource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourcesModule {

    @Singleton
    @Binds
    abstract fun bindRemoteDataSource(
        remoteDataSource: MasjedRemoteDatasourceImpl,
    ): MasjedRemoteDatasource

    @Singleton
    @Binds
    abstract fun bindLocalDataSource(
        localDataSource: MasjedLocalDatasourceImpl,
    ): MasjedLocalDatasource
}
