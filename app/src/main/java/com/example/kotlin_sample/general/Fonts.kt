package com.example.kotlin_sample.general

import DIRECTORY_FONT
import android.content.Context
import android.graphics.Typeface

class Fonts(val context: Context, val font: String) {

    private var typeface: Typeface? = null


    fun getTypeface(): Typeface? {
        typeface = Typeface.createFromAsset(context.assets, DIRECTORY_FONT + "/" + font)
        return typeface
    }


}