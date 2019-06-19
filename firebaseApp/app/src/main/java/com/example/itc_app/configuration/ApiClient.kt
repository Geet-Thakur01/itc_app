package com.example.geet.retroexample.configuration

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val BASE_URL = "https://mobile-tha-server.firebaseapp.com"
    private val retrofit: Retrofit

    init {
        retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    fun getInstance(): Retrofit {
        retrofit.let { return retrofit }
    }
}