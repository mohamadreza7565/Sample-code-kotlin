package com.example.kotlin_sample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.viewpager.widget.ViewPager
import com.example.kotlin_sample.adapters.vp.ViewPagerAdapter
import com.example.kotlin_sample.fragments.UsersFragment
import com.example.kotlin_sample.fragments.ThreeFragment
import com.example.kotlin_sample.fragments.TwoFragment
import com.example.kotlin_sample.models.ViewPagerModel
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_view_pager.view.*

class ViewPagerActivity : AppCompatActivity() {

    val context: Context = this
    var viewPager: ViewPager? = null
    var tabLayout: TabLayout? = null
    var imv_back: ImageView? = null
    val usersFragment = UsersFragment().newInstance()
    val twoFragment = TwoFragment().newInstance()
    val threeFragment = ThreeFragment().newInstance()
    val arrayList = ArrayList<ViewPagerModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
        initView(window.decorView)
        onClick()

        arrayList.add(ViewPagerModel("Users", usersFragment))
        arrayList.add(ViewPagerModel("Gallery", twoFragment))
        arrayList.add(ViewPagerModel("Settings", threeFragment))
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, arrayList)
        viewPager?.adapter = viewPagerAdapter
        tabLayout?.setupWithViewPager(viewPager)

    }

    private fun onClick() {
        imv_back?.setOnClickListener {
            finish()
        }
    }

    private fun initView(view: View) {
        viewPager = view.view_pager
        tabLayout = view.tab_layout
        imv_back = view.imv_back
    }
}