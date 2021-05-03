package com.example.kotlin_sample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView
import androidx.viewpager.widget.ViewPager
import com.example.kotlin_sample.adapters.vp.ViewPagerAdapter
import com.example.kotlin_sample.fragments.UsersFragment
import com.example.kotlin_sample.fragments.ThreeFragment
import com.example.kotlin_sample.fragments.TwoFragment
import com.example.kotlin_sample.models.ViewPagerModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tbuonomo.morphbottomnavigation.MorphBottomNavigationView
import kotlinx.android.synthetic.main.activity_bottom_navigation_view.view.*

class BottomNavigationViewActivity : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener {

    val context: Context = this
    var btm_nav: MorphBottomNavigationView? = null
    var viewPager: ViewPager? = null
    var cb_smooth: CheckBox? = null
    var imv_back: ImageView? = null
    val usersFragment = UsersFragment().newInstance()
    val twoFragment = TwoFragment().newInstance()
    val threeFragment = ThreeFragment().newInstance()
    val arrayList = ArrayList<ViewPagerModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation_view)
        initView(window.decorView)
        onClick()

        arrayList.add(ViewPagerModel("شماره 1", usersFragment))
        arrayList.add(ViewPagerModel("شماره 2", twoFragment))
        arrayList.add(ViewPagerModel("شماره 3", threeFragment))
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, arrayList)
        viewPager?.adapter = viewPagerAdapter


    }

    private fun onClick() {
        btm_nav?.setOnNavigationItemSelectedListener(this)

        imv_back?.setOnClickListener {
            finish()
        }
    }

    private fun initView(view: View) {
        btm_nav = view.bottomNavigationView
        viewPager = view.viewPager
        cb_smooth = view.cb_smooth
        imv_back = view.imv_back
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (cb_smooth?.isChecked!!) {
            when (item.itemId) {
                R.id.nav_user ->
                    viewPager?.currentItem = 0
                R.id.nav_gallery ->
                    viewPager?.currentItem = 1
                R.id.nav_manage ->
                    viewPager?.currentItem = 2
            }
        } else {
            when (item.itemId) {
                R.id.nav_user ->
                    viewPager?.setCurrentItem(0, false)
                R.id.nav_gallery ->
                    viewPager?.setCurrentItem(1, false)
                R.id.nav_manage ->
                    viewPager?.setCurrentItem(2, false)
            }
        }


        return true
    }
}