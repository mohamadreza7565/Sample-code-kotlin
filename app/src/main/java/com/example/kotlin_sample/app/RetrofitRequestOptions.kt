package com.example.kotlin_sample.app

import BASE_URL
import com.example.kotlin_sample.api.ServerAPI
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitRequestOptions {
    fun getApi(): ServerAPI {

        val gson = GsonBuilder().setLenient().create()
        val client = OkHttpClient()
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        return retrofit.create(ServerAPI::class.java)
    }
}