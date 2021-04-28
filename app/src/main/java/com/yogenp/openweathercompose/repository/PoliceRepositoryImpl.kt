package com.yogenp.openweathercompose.repository

import com.yogenp.openweathercompose.network.PoliceNetworkService

class PoliceRepositoryImpl(
    private val networkService: PoliceNetworkService
) : PoliceRepository {
    override suspend fun getForceList() {
        networkService.getForceList()
    }

    override suspend fun getForceInfo(forceName: String) {
        networkService.getForceInfo(forceName)
    }
}