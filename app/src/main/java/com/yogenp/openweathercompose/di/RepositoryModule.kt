package com.yogenp.openweathercompose.di

import com.yogenp.openweathercompose.network.PoliceNetworkService
import com.yogenp.openweathercompose.repository.PoliceRepository
import com.yogenp.openweathercompose.repository.PoliceRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    /*
    * Provide Remote/Local DataSource Repository
    * */
    @Provides
    @Singleton
    fun provideRepository(
        networkService: PoliceNetworkService
    ): PoliceRepository {
        return PoliceRepositoryImpl(
            networkService
        )
    }
}