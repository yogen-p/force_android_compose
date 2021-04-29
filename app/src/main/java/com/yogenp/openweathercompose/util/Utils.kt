package com.yogenp.openweathercompose.util

import com.yogenp.openweathercompose.network.model.ForceInfoDTO
import com.yogenp.openweathercompose.network.model.ForceListDTO

val FORCE_LIST_DUMMY = listOf(
    ForceListDTO(
        id = "avon-and-somerset",
        name = "Avon and Somerset Constabulary"
    ),
    ForceListDTO(
        id = "derbyshire",
        name = "Derbyshire Constabulary"
    ),
    ForceListDTO(
        id = "cheshire",
        name = "Cheshire Constabulary"
    )
)


val FORCE_INFO_DUMMY = ForceInfoDTO(
    description = "desc",
    url = "http://www.derbyshire.police.uk/",
    engagement_methods = listOf(),
    telephone = "111",
    id = "derbyshire",
    name = "Derbyshire Constabulary"
)

