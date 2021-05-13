package com.example.kotlin_sample.api;

import com.example.kotlin_sample.models.NewsModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServerAPI {

    @GET("/v2/top-headlines?apiKey=fa1ee7f865a44cee963c8e06ae46768c")
    Call<NewsModel> getNews(
            @Query("country") String country
    );

}
