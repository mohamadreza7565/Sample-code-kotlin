package com.example.kotlin_sample.adapters.vp

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.kotlin_sample.models.ViewPagerModel


class ViewPagerAdapter(fragmentManager: FragmentManager,val fragments: ArrayList<ViewPagerModel>) :
    FragmentStatePagerAdapter(fragmentManager) {

    override fun getPageTitle(position: Int) = fragments[position].title

    override fun getCount() = fragments.size

    override fun getItem(position: Int) = fragments[position].fragment


}