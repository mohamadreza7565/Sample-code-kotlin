package com.example.kotlin_sample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_sample.api.NewsServerController
import com.example.kotlin_sample.`interface`.OnObjectServerCallback
import com.example.kotlin_sample.adapters.rv.NewsRVAdapter
import com.example.kotlin_sample.models.ArticlesModel
import com.example.kotlin_sample.models.NewsModel
import kotlinx.android.synthetic.main.activity_request_to_server.view.*

class RequestToServerActivity : AppCompatActivity() {

    val context: Context = this
    var newsRVAdapter: NewsRVAdapter? = null
    var pb_loading: ProgressBar? = null
    var rv: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_to_server)
        initView(window.decorView);

        val newsServerController = NewsServerController().getNews(object :
            OnObjectServerCallback<NewsModel>() {

            override fun onStart() {
                pb_loading?.visibility = View.VISIBLE
            }

            override fun onResponse(result: NewsModel) {
                pb_loading?.visibility = View.GONE
                rv?.layoutManager = LinearLayoutManager(context)
                newsRVAdapter = NewsRVAdapter(context,
                    result.articles,
                    object : NewsRVAdapter.OnItemClickListener {
                        override fun onItemClick(position: Int, newsModel: ArticlesModel) {
                            Toast.makeText(context, newsModel.title, Toast.LENGTH_LONG).show()
                        }
                    })
                rv?.adapter = newsRVAdapter
            }

            override fun onFailure(error: String) {
                pb_loading?.visibility = View.GONE
                Toast.makeText(context, "Error", Toast.LENGTH_LONG).show()
            }


        })

    }

    private fun initView(view: View) {
        rv = view.rv
        pb_loading = view.pb_loading
    }
}