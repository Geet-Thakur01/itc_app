package com.example.geet.retroexample.configuration

import android.content.Context
import android.net.ConnectivityManager

object AppUtility {

    fun isInternetConnected(ctx:Context): Boolean {
        val cm = ctx.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = cm.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}