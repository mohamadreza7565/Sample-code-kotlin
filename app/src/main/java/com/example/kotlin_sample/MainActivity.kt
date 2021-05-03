package com.example.kotlin_sample

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    var context: Context = this
    var btn_rv: Button? = null
    var btn_vp: Button? = null
    var btn_btm_nav: Button? = null
    var btn_drawer: Button? = null
    var btn_map: Button? = null
    var btn_notification: Button? = null
    var btn_animations: Button? = null
    var btn_server: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView(window.decorView)
        onClick()
    }

    private fun onClick() {
        btn_rv?.setOnClickListener {
            val intent = Intent(context, RecyclerViewActivity::class.java)
            startActivity(intent)
        }
        btn_vp?.setOnClickListener {
            val intent = Intent(context, ViewPagerActivity::class.java)
            startActivity(intent)
        }
        btn_btm_nav?.setOnClickListener {
            val intent = Intent(context, BottomNavigationViewActivity::class.java)
            startActivity(intent)
        }
        btn_drawer?.setOnClickListener {
            val intent = Intent(context, DrawerMenuActivity::class.java)
            startActivity(intent)
        }

        btn_map?.setOnClickListener {
            val intent = Intent(context, MapActivity::class.java)
            startActivity(intent)
        }
        btn_animations?.setOnClickListener {
            val intent = Intent(context, AnimationsActivity::class.java)
            startActivity(intent)
        }
        btn_server?.setOnClickListener {
            val intent = Intent(context, RequestToServerActivity::class.java)
            startActivity(intent)
        }
        btn_notification?.setOnClickListener {
            val intent = Intent(context, NotificationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initView(view: View) {
        btn_rv = view.btn_rv
        btn_vp = view.btn_vp
        btn_btm_nav = view.btn_btm_nav
        btn_drawer = view.btn_drawer
        btn_map = view.btn_map
        btn_notification = view.btn_notif
        btn_server = view.btn_server
        btn_animations = view.btn_anim
    }
}