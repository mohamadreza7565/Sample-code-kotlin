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
import kotlinx.android.synthetic.main.user_rv_items.view.*

class UsersRVAdapter(
    val context: Context,
    val list: ArrayList<UserModel>,
    val onItemClickListener: OnItemClickListener,
) :
    RecyclerView.Adapter<UsersRVAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(context).inflate(R.layout.user_rv_items, parent, false)
    )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position],context)

        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(position, list[position])
        }

    }

    override fun getItemCount() = list.size

    class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

        private val imageView = view.imageView
        private val userName = view.name
        private val userEmail = view.email


        fun bind(item: UserModel, context: Context) {
            userName.text = item.firstName + " " + item.lastName
            userEmail.text = item.email

            val options = RequestOptions()
                .placeholder(R.drawable.ic_person)
                .circleCrop()
                .error(R.drawable.ic_person)
            Glide.with(context)
                .setDefaultRequestOptions(options)
                .load(item.avatar)
                .into(imageView)

        }


    }

    interface OnItemClickListener {
        fun onItemClick(position: Int, userModel: UserModel)
    }

}