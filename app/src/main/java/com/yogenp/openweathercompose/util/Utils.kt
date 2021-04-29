package com.yogenp.openweathercompose.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.*
import android.net.NetworkCapabilities.*
import android.os.Build
import android.text.Html
import com.yogenp.openweathercompose.network.model.ForceInfoDTO
import com.yogenp.openweathercompose.network.model.ForceListDTO

fun isConnected(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false

        return when {
            networkCapabilities.hasTransport(TRANSPORT_WIFI) -> true
            networkCapabilities.hasTransport(TRANSPORT_CELLULAR) -> true
            networkCapabilities.hasTransport(TRANSPORT_ETHERNET) -> true
            else -> false
        }
    } else {
        connectivityManager.activeNetworkInfo?. run {
            return when(this.type){
                TYPE_WIFI -> true
                TYPE_MOBILE -> true
                TYPE_ETHERNET -> true
                else -> false
            }
        }
    }

    return false
}

fun parseHtml(text: String): String = if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
    Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT).toString()
} else {
    Html.fromHtml(text).toString()
}

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

