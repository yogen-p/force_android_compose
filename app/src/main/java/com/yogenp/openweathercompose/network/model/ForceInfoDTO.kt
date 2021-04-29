package com.yogenp.openweathercompose.network.model

import com.google.gson.annotations.SerializedName

data class ForceInfoDTO(

    @SerializedName("description")
    val description: String?,

    @SerializedName("url")
    val url: String?,

    @SerializedName("engagement_methods")
    val engagement_methods: List<EngMethods>?,

    @SerializedName("telephone")
    val telephone: String?,

    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String

)
