package com.yogenp.openweathercompose.repository

import com.yogenp.openweathercompose.network.model.ForceInfoDTO
import com.yogenp.openweathercompose.network.model.ForceListDTO
import com.yogenp.openweathercompose.util.Resource

interface ForceRepository {

    suspend fun getForceList() : Resource<List<ForceListDTO>>

    suspend fun getForceInfo(forceId: String) : Resource<ForceInfoDTO>

}