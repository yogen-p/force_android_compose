package com.yogenp.openweathercompose.network

import retrofit2.http.Field
import retrofit2.http.GET

interface PoliceNetworkService {

    @GET(".")
    suspend fun getForceList()

    @GET("{forceName}")
    suspend fun getForceInfo(
        @Field("forceName") forceName: String
    )
}