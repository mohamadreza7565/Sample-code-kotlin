package com.example.kotlin_sample.models

data class DrawerMenuModel(
    val selected_: Boolean,
    val title_: String,
    val icon_: Int,
) {
    var selected: Boolean
        set(value) {
            selected_
        }
        get() = selected_

    var title: String
        get() = title_
        set(value) {
            title_
        }
    var icon: Int
        get() = icon_
        set(value) {
            icon_
        }


}