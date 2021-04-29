package com.yogenp.openweathercompose.network.model

import com.google.gson.annotations.SerializedName

data class EngMethods(
    @SerializedName("url")
    val url: String?,

    @SerializedName("type")
    val type: String,

    @SerializedName("description")
    val description: String?,

    @SerializedName("title")
    val title: String
)
