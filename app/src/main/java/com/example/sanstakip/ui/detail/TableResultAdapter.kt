package com.example.sanstakip.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sanstakip.databinding.TableResultBinding
import com.example.sanstakip.model.ResultModel

class TableResultAdapter(private val tableResult: ArrayList<ResultModel>) : RecyclerView.Adapter<TableResultAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TableResultBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val result = tableResult[position]
        holder.bind(result)
    }

    override fun getItemCount(): Int {
        return tableResult.size
    }

    inner class ViewHolder(private val binding: TableResultBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(result: ResultModel) {
            binding.model = result
        }
    }
}
