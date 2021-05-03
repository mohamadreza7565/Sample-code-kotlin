package com.example.kotlin_sample.models

import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("data")
    val userModels: ArrayList<UserModel>
)