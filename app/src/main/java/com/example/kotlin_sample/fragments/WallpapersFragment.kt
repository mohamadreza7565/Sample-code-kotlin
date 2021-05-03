package com.example.kotlin_sample.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_sample.R
import com.example.kotlin_sample.`interface`.OnObjectServerCallback
import com.example.kotlin_sample.adapters.rv.WallpapersRVAdapter
import com.example.kotlin_sample.models.NewsModel
import com.example.kotlin_sample.models.WallpaperModel
import kotlinx.android.synthetic.main.fragment_wallpapers_layout.view.*

class WallpapersFragment : Fragment() {

    var rv: RecyclerView? = null
    var wallpapersAdapter: WallpapersRVAdapter? = null
    var wallpapers = ArrayList<WallpaperModel>()

    fun newInstance(): WallpapersFragment {
        val args = Bundle()
        val fragment = WallpapersFragment()
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? =
        LayoutInflater.from(context).inflate(R.layout.fragment_wallpapers_layout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)

        wallpapers.add(WallpaperModel(1, R.drawable.walpager_1))
        wallpapers.add(WallpaperModel(2, R.drawable.walpager_2))
        wallpapers.add(WallpaperModel(3, R.drawable.walpager_3))
        wallpapers.add(WallpaperModel(4, R.drawable.walpager_4))
        wallpapers.add(WallpaperModel(5, R.drawable.walpager_5))
        wallpapers.add(WallpaperModel(6, R.drawable.walpager_6))
        wallpapers.add(WallpaperModel(7, R.drawable.walpager_7))
        wallpapers.add(WallpaperModel(8, R.drawable.walpager_8))
        wallpapers.add(WallpaperModel(9, R.drawable.walpager_9))
        wallpapers.add(WallpaperModel(10, R.drawable.walpager_10))
        wallpapers.add(WallpaperModel(11, R.drawable.walpager_11))
        wallpapers.add(WallpaperModel(12, R.drawable.walpager_12))

        rv?.layoutManager = GridLayoutManager(requireContext(), 2)
        wallpapersAdapter = WallpapersRVAdapter(requireContext(), wallpapers,
            object : WallpapersRVAdapter.OnItemClickListener {
                override fun onItemClick(position: Int, wallpaperModels: WallpaperModel) {

                }
            })
        rv?.adapter = wallpapersAdapter

    }

    private fun initView(view: View) {
        rv = view.rv
    }

}