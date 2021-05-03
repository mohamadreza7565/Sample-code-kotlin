package com.example.kotlin_sample.models

import com.google.gson.annotations.SerializedName

data class NewsModel(
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int,
    @SerializedName("articles")
    val articles: ArrayList<ArticlesModel>,
)