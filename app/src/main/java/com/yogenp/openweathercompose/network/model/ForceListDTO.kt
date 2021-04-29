package com.yogenp.openweathercompose.network.model

import com.google.gson.annotations.SerializedName

data class ForceListDTO(
    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String
)
