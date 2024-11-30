package com.example.triaje

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

private fun isNetworkAvailable(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork
    val networkCapabilities = connectivityManager.getNetworkCapabilities(network)

    // Verifica si el dispositivo tiene una red con capacidad para acceder a internet
    return networkCapabilities != null && networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
}
