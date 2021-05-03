package com.example.kotlin_sample.`interface`

abstract class OnObjectServerCallback<T> {
    abstract fun onStart()
    abstract fun onResponse(result: T)
    abstract fun onFailure(error: String)
}