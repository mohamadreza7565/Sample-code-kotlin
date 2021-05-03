package com.example.kotlin_sample.general

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin_sample.R
import java.io.File

fun ImageView.loadImage(uri: String?) {
    val options = RequestOptions()
        .placeholder(R.drawable.ic_person)
        .circleCrop()
        .error(R.drawable.ic_person)
    if (uri?.contains("file:///android_asset")!!) {
        val imageUri = Uri.parse(uri)
        Glide.with(this.context)
            .setDefaultRequestOptions(options)
            .load(imageUri)
            .into(this)
    } else {
        Glide.with(this.context)
            .setDefaultRequestOptions(options)
            .load(uri)
            .into(this)
    }
}