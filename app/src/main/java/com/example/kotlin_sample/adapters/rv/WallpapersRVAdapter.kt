package com.example.kotlin_sample.adapters.rv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin_sample.R
import com.example.kotlin_sample.models.UserModel
import com.example.kotlin_sample.models.WallpaperModel
import kotlinx.android.synthetic.main.user_rv_items.view.*
import kotlinx.android.synthetic.main.wallpaper_rv_items.view.*

class WallpapersRVAdapter(
    val context: Context,
    val list: ArrayList<WallpaperModel>,
    val onItemClickListener: OnItemClickListener,
) :
    RecyclerView.Adapter<WallpapersRVAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(context).inflate(R.layout.wallpaper_rv_items, parent, false)
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

        val imv_wallpaper = view.imv_wallpaper

        fun bind(item: WallpaperModel, context: Context) {
            val options = RequestOptions()
                .placeholder(R.drawable.ic_gallery)
                .error(R.drawable.ic_error_image)
            Glide.with(context)
                .setDefaultRequestOptions(options)
                .load(item.image)
                .into(imv_wallpaper)
        }


    }

    interface OnItemClickListener {
        fun onItemClick(position: Int, wallpaperModels: WallpaperModel)
    }

}