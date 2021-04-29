package com.yogenp.openweathercompose.di

import com.google.gson.GsonBuilder
import com.yogenp.openweathercompose.network.ForceApiService
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
    fun provideRecipeService(): ForceApiService{
        return Retrofit.Builder()
            .baseUrl("https://data.police.uk/api/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ForceApiService::class.java)
    }
}