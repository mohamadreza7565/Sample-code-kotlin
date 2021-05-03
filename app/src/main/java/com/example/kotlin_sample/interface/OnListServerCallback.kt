package com.example.kotlin_sample.`interface`

abstract class OnListServerCallback<T> {
    abstract fun onResponse(list: ArrayList<T>)
    abstract fun onFailure(status: String)
}