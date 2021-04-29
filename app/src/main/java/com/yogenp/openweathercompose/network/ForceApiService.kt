package com.yogenp.openweathercompose.network

import com.yogenp.openweathercompose.network.model.ForceInfoDTO
import com.yogenp.openweathercompose.network.model.ForceListDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface ForceApiService {

    @GET("forces")
    suspend fun getForceList(): List<ForceListDTO>

    @GET("forces/{forceName}")
    suspend fun getForceInfo(
        @Path("forceName") forceName: String
    ): ForceInfoDTO
}