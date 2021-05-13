package com.example.kotlin_sample.adapters.rv

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_sample.R
import com.example.kotlin_sample.models.DrawerMenuModel
import kotlinx.android.synthetic.main.drawer_rv_item.view.*
import kotlin.coroutines.coroutineContext

class DrawerMenuRVAdapter(
    val context: Context,
    val list: ArrayList<DrawerMenuModel>,
    val onItemClickListener: OnItemClickListener,
) : RecyclerView.Adapter<DrawerMenuRVAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(context).inflate(R.layout.drawer_rv_item, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position], context)

        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(position, list[position])
        }
    }


    override fun getItemCount() = list.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imv_icon = view.imv_icon
        val tv_title = view.tv_title
        val rl_item = view.rl_item

        fun bind(item: DrawerMenuModel, context: Context) {
            tv_title.text = item.title
            imv_icon.setImageResource(item.icon)
            if (item.selected) {
                rl_item.setBackgroundColor(context.resources.getColor(R.color.colorBlueTransparent))
            } else {
                rl_item.setBackgroundColor(context.resources.getColor(R.color.white))
            }
        }

    }

    interface OnItemClickListener {
        fun onItemClick(position: Int, drawerMenuModel: DrawerMenuModel)
    }
}