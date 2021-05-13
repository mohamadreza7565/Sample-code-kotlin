package com.example.kotlin_sample.general

import DIRECTORY_FONT
import android.content.Context
import android.graphics.Typeface

class Fonts(val context: Context, val font: String) {

    fun getTypeface(): Typeface =
        Typeface.createFromAsset(context.assets, DIRECTORY_FONT + "/" + font)

}