package com.example.sanstakip.helper

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sanstakip.model.ResultModel
import com.example.sanstakip.model.SayisalSuperModel
import com.example.sanstakip.ui.detail.TableResultAdapter
import com.example.sanstakip.ui.homepage.drawAdapter

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("app:drawList", "app:onDetailClicked")
    fun drawList(
        recyclerView: RecyclerView,
        draws: ArrayList<SayisalSuperModel>?,
        onDetailClicked: (SayisalSuperModel) -> Unit
    ) {
        draws?.let {
            val adapter = drawAdapter(it)
            adapter.setonClickedDetailListener(onDetailClicked)
            val layoutManager = LinearLayoutManager(recyclerView.context)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = adapter
        }
    }

    @JvmStatic
    @BindingAdapter("app:resultList")
    fun resultList(
        recyclerView: RecyclerView,
        results: ArrayList<ResultModel>?
    ) {
        results?.let {
            val adapter = TableResultAdapter(it)
            val layoutManager = LinearLayoutManager(recyclerView.context)
            recyclerView.layoutManager = layoutManager
            recyclerView.adapter = adapter
        }
    }

}