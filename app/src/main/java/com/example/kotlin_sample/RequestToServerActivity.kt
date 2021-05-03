package com.example.kotlin_sample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin_sample.api.NewsServerController
import com.example.kotlin_sample.`interface`.OnObjectServerCallback
import com.example.kotlin_sample.models.NewsModel

class RequestToServerActivity : AppCompatActivity() {

    val context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_to_server)

        val newsServerController = NewsServerController().getNews(object :
            OnObjectServerCallback<NewsModel>() {

            override fun onStart() {
                Toast.makeText(context, "Start", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(result: NewsModel) {
                Toast.makeText(context, "result : " + result.articles[0].content, Toast.LENGTH_LONG)
                    .show()
            }

            override fun onFailure(error: String) {
                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
            }


        })

    }
}