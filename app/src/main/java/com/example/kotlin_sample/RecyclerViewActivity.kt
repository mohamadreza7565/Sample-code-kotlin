package com.example.kotlin_sample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_sample.adapters.rv.UsersRVAdapter
import com.example.kotlin_sample.general.JsonReader
import com.example.kotlin_sample.models.DataModel
import com.example.kotlin_sample.models.UserModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_recycler_view.view.*
import kotlinx.android.synthetic.main.fragment_one_layout.view.rv

class RecyclerViewActivity : AppCompatActivity(), UsersRVAdapter.OnItemClickListener {

    var context: Context = this
    var rv: RecyclerView? = null
    var imv_back: ImageView? = null
    var adapter: UsersRVAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        initView(window.decorView)
        onClick();

        val json: String = JsonReader().fromAssets(context, "json")
        val dataModel: DataModel = Gson().fromJson(json, DataModel::class.java)

        rv?.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(context, dataModel.userModels, this)
        rv?.adapter = adapter

    }

    private fun initView(view: View) {
        rv = view.rv
        imv_back = view.imv_back
    }

    private fun onClick() {
        imv_back?.setOnClickListener {
            finish()
        }
    }

    override fun onItemClick(position: Int, userModel: UserModel) {
        var content: String = userModel.firstName + " " + userModel.lastName
        content += "\n" + userModel.email
        Toast.makeText(context, content, Toast.LENGTH_LONG).show()
    }

}