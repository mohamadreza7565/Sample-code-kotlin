package com.example.kotlin_sample.api

import com.example.kotlin_sample.models.NewsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ServerAPI {

    @GET("/v2/top-headlines?apiKey=fa1ee7f865a44cee963c8e06ae46768c")
    fun getNews(@Query("country") key: String): retrofit2.Call<NewsModel>

}