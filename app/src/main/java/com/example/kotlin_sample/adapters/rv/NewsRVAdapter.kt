package com.example.kotlin_sample.adapters.rv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin_sample.R
import com.example.kotlin_sample.models.ArticlesModel
import com.example.kotlin_sample.models.NewsModel
import com.example.kotlin_sample.models.UserModel
import com.example.kotlin_sample.models.WallpaperModel
import kotlinx.android.synthetic.main.news_rv_items.view.*
import kotlinx.android.synthetic.main.user_rv_items.view.*
import kotlinx.android.synthetic.main.wallpaper_rv_items.view.*

class NewsRVAdapter(
    val context: Context,
    val list: ArrayList<ArticlesModel>,
    val onItemClickListener: OnItemClickListener,
) :
    RecyclerView.Adapter<NewsRVAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(context).inflate(R.layout.news_rv_items, parent, false)
    )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position], context)

        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(position, list[position])
        }

    }

    override fun getItemCount() = list.size

    class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

        var imv_news = view.imv_news
        var tv_title = view.tv_title
        var tv_author = view.tv_author
        var tv_published_at = view.tv_published_at

        fun bind(item: ArticlesModel, context: Context) {

            if (item.urlToImage != null) {
                val options = RequestOptions()
                    .placeholder(R.drawable.ic_gallery)
                    .error(R.drawable.ic_error_image)
                Glide.with(context)
                    .setDefaultRequestOptions(options)
                    .load(item.urlToImage)
                    .into(imv_news)
            } else {
                Glide.with(context)
                    .load(R.drawable.ic_error_image)
                    .into(imv_news)
            }

            tv_author.text = item.author
            tv_title.text = item.title
            tv_published_at.text = item.publishedAt
        }


    }

    interface OnItemClickListener {
        fun onItemClick(position: Int, newsModel: ArticlesModel)
    }

}