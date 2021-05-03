package com.example.kotlin_sample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.kotlin_sample.adapters.rv.DrawerMenuRVAdapter
import com.example.kotlin_sample.adapters.vp.ViewPagerAdapter
import com.example.kotlin_sample.fragments.UsersFragment
import com.example.kotlin_sample.fragments.ThreeFragment
import com.example.kotlin_sample.fragments.TwoFragment
import com.example.kotlin_sample.models.DrawerMenuModel
import com.example.kotlin_sample.models.ViewPagerModel
import kotlinx.android.synthetic.main.activity_drawer_menu.view.*
import kotlinx.android.synthetic.main.drawer_layout.view.*

class DrawerMenuActivity : AppCompatActivity(), DrawerMenuRVAdapter.OnItemClickListener {

    val context: Context = this
    var imv_open_drawer: ImageView? = null
    var imv_back: ImageView? = null
    var drawer_layout: DrawerLayout? = null
    var view_pager: ViewPager? = null
    var rv_navigation: RecyclerView? = null
    var drawerItems = ArrayList<DrawerMenuModel>()
    var fragments = ArrayList<ViewPagerModel>()
    val usersFragment = UsersFragment().newInstance()
    val twoFragment = TwoFragment().newInstance()
    val threeFragment = ThreeFragment().newInstance()
    var drawerMenuRVAdapter: DrawerMenuRVAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer_menu)
        initView(window.decorView)
        onClick()
        initViewPager()
        initDrawer()


    }

    private fun initViewPager() {
        fragments.add(ViewPagerModel("Users", usersFragment))
        fragments.add(ViewPagerModel("Gallery", twoFragment))
        fragments.add(ViewPagerModel("Settings", threeFragment))

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, fragments)
        view_pager?.adapter = viewPagerAdapter
    }

    private fun initDrawer() {
        drawerItems.add(DrawerMenuModel(true, "Users", R.drawable.ic_person))
        drawerItems.add(DrawerMenuModel(false, "Gallery", R.drawable.ic_gallery))
        drawerItems.add(DrawerMenuModel(false, "Settings", R.drawable.ic_settings))
        rv_navigation?.layoutManager = LinearLayoutManager(context)
        drawerMenuRVAdapter = DrawerMenuRVAdapter(context, drawerItems, this)
        rv_navigation?.adapter = drawerMenuRVAdapter

    }

    private fun onClick() {
        imv_open_drawer?.setOnClickListener {
            drawer_layout?.openDrawer(Gravity.LEFT)
        }

        imv_back?.setOnClickListener {
            finish()
        }
    }

    private fun initView(view: View) {
        imv_open_drawer = view.imv_open_drawer
        imv_back = view.imv_back
        drawer_layout = view.drawer_layout
        view_pager = view.view_pager
        rv_navigation = view.rv_navigation
    }

    override fun onBackPressed() {
        if (drawer_layout?.isDrawerOpen(Gravity.LEFT)!!) {
            drawer_layout?.closeDrawer(Gravity.LEFT)
        } else {
            finish()
        }
    }

    override fun onItemClick(position: Int, drawerMenuModel: DrawerMenuModel) {
        view_pager?.setCurrentItem(position, false)
        drawer_layout?.closeDrawer(Gravity.LEFT)
    }

}