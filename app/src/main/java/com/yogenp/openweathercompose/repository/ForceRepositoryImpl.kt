package com.yogenp.openweathercompose.repository

import com.yogenp.openweathercompose.network.ForceApiService
import com.yogenp.openweathercompose.network.model.ForceInfoDTO
import com.yogenp.openweathercompose.network.model.ForceListDTO
import com.yogenp.openweathercompose.presentation.BaseApplication
import com.yogenp.openweathercompose.util.Resource
import com.yogenp.openweathercompose.util.isConnected

class ForceRepositoryImpl(
    private val apiService: ForceApiService,
    private val app: BaseApplication
) : ForceRepository {
    override suspend fun getForceList(): Resource<List<ForceListDTO>> {
        return if (isConnected(app.applicationContext)) {
            Resource.Success(apiService.getForceList())
        } else {
            Resource.Error(message = "Couldn't reach Server!")
        }

    }

    override suspend fun getForceInfo(forceId: String): Resource<ForceInfoDTO> {
        return if (isConnected(app.applicationContext)) {
            Resource.Success(apiService.getForceInfo(forceId))
        } else {
            Resource.Error(message = "Couldn't reach Server!")
        }

    }
}