package com.example.kotlin_sample.general

import android.content.Context
import java.lang.Exception

class JsonReader {


    fun fromAssets(context: Context, jsonPath: String): String {

        var json: String = ""

        try {
            json = context.assets.open(jsonPath + ".json").bufferedReader().use {
                it.readText()
            }
        } catch (e: Exception) {

        }

        return json;

    }

}