package com.yogenp.openweathercompose.di

import com.google.gson.GsonBuilder
import com.yogenp.openweathercompose.network.PoliceNetworkService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRecipeService(): PoliceNetworkService{
        return Retrofit.Builder()
            .baseUrl("https://data.police.uk/api/forces/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(PoliceNetworkService::class.java)
    }
}