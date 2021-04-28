package com.yogenp.openweathercompose.repository

interface PoliceRepository {

    suspend fun getForceList()

    suspend fun getForceInfo(forceName: String)

}