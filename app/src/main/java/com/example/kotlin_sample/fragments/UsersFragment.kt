package com.example.kotlin_sample.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_sample.R
import com.example.kotlin_sample.adapters.rv.UsersRVAdapter
import com.example.kotlin_sample.general.JsonReader
import com.example.kotlin_sample.models.DataModel
import com.example.kotlin_sample.models.UserModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_one_layout.view.*

class UsersFragment : Fragment(), UsersRVAdapter.OnItemClickListener {

    var rv: RecyclerView? = null
    var adapter: UsersRVAdapter? = null

    fun newInstance(): UsersFragment {
        val args = Bundle()
        val fragment = UsersFragment()
        fragment.arguments = args
        return fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? = LayoutInflater.from(context).inflate(R.layout.fragment_one_layout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)

        val json: String = JsonReader().fromAssets(requireContext(), "json")
        val dataModel: DataModel = Gson().fromJson(json, DataModel::class.java)

        rv?.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(requireContext(), dataModel.userModels, this)
        rv?.adapter = adapter
    }

    private fun initView(view: View) {
        rv = view.rv
    }

    override fun onItemClick(position: Int, userModel: UserModel) {
        var content: String = userModel.firstName + " " + userModel.lastName
        content += "\n" + userModel.email
        Toast.makeText(context, content, Toast.LENGTH_LONG).show()
    }

}