package com.yogenp.openweathercompose.di

import android.content.Context
import com.yogenp.openweathercompose.network.ForceApiService
import com.yogenp.openweathercompose.presentation.BaseApplication
import com.yogenp.openweathercompose.repository.ForceRepository
import com.yogenp.openweathercompose.repository.ForceRepositoryImpl
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
        apiService: ForceApiService,
        app: BaseApplication
    ): ForceRepository {
        return ForceRepositoryImpl(
            apiService,
            app
        )
    }
}