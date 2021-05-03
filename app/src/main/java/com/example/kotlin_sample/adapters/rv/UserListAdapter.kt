package com.example.kotlin_sample.adapters.rv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_sample.R
import com.example.kotlin_sample.general.loadImage
import com.example.kotlin_sample.models.UserModel
import kotlinx.android.synthetic.main.user_rv_items.view.*

class UserListAdapter(
    val context: Context,
    val userModels: ArrayList<UserModel>,
    val onItemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<UserListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(context).inflate(R.layout.user_rv_items, parent, false)
    )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(userModels[position])

        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(position, userModels[position])
        }

    }

    override fun getItemCount() = userModels.size

    class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

        private val imageView = view.imageView
        private val userName = view.name
        private val userEmail = view.email


        fun bind(country: UserModel) {
            userName.text = country.firstName + " " + country.lastName
            userEmail.text = country.email
            imageView.loadImage(country.avatar)
        }


    }

    interface OnItemClickListener {
        fun onItemClick(position: Int, userModel: UserModel)
    }

}