package com.example.kotlin_sample.api

import BASE_URL
import com.example.kotlin_sample.`interface`.OnObjectServerCallback
import com.example.kotlin_sample.models.NewsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsServerController() {

    fun getNews(onObjectServerCallback: OnObjectServerCallback<NewsModel>) {

        onObjectServerCallback.onStart()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val serverAPI = retrofit.create(ServerAPI::class.java)

        val call: Call<NewsModel> = serverAPI.getNews( "us")

        call.enqueue(object : Callback<NewsModel> {
            override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                onObjectServerCallback.onResponse(response.body()!!)
            }

            override fun onFailure(call: Call<NewsModel>, t: Throwable) {
                onObjectServerCallback.onFailure(t.message!!)
            }

        })

    }

}