package com.example.kotlin_sample.api

import com.example.kotlin_sample.`interface`.OnListServerCallback
import com.example.kotlin_sample.`interface`.OnObjectServerCallback
import com.example.kotlin_sample.app.RetrofitRequestOptions
import com.example.kotlin_sample.models.NewsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsServerController() {

    var onObjectServerCallback: OnObjectServerCallback<NewsModel>? = null
    var onListServerCallback: OnListServerCallback<NewsModel>? = null

    constructor(onObjectServerCallback: OnObjectServerCallback<NewsModel>) : this() {
        this.onObjectServerCallback = onObjectServerCallback
    }

    constructor(onListServerCallback: OnListServerCallback<NewsModel>) : this() {
        this.onListServerCallback = onListServerCallback
    }


    fun getNews(onObjectServerCallback: OnObjectServerCallback<NewsModel>) {

        onObjectServerCallback.onStart()

        RetrofitRequestOptions().getApi().getNews("us").enqueue(object : Callback<NewsModel> {
            override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                onObjectServerCallback.onResponse(response.body()!!)
            }

            override fun onFailure(call: Call<NewsModel>, t: Throwable) {
                onObjectServerCallback.onFailure(t.message!!)
            }
        })

    }

//    fun getNews(onObjectServerCallback: OnObjectServerCallback<NewsModel>) {
//
//        onObjectServerCallback.onStart()
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val serverAPI = retrofit.create(ServerAPI::class.java)
//
//        val call: Call<NewsModel> = serverAPI.getNews( "us")
//
//        call.enqueue(object : Callback<NewsModel> {
//            override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
//                onObjectServerCallback.onResponse(response.body()!!)
//            }
//
//            override fun onFailure(call: Call<NewsModel>, t: Throwable) {
//                onObjectServerCallback.onFailure(t.message!!)
//            }
//
//        })
//
//    }


}