package com.example.sanstakip.ui.homepage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sanstakip.databinding.DrawCardBinding
import com.example.sanstakip.model.SayisalSuperModel

class drawAdapter(private val drawList: ArrayList<SayisalSuperModel>): RecyclerView.Adapter<drawAdapter.ViewHolder>() {

    private var onClickedDetail: ((SayisalSuperModel) -> Unit)? = null

    fun setonClickedDetailListener(listener: ((SayisalSuperModel) -> Unit)?) {
        this.onClickedDetail = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): drawAdapter.ViewHolder {
        val binding = DrawCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: drawAdapter.ViewHolder, position: Int) {
        holder.bind(drawList[position])
    }

    override fun getItemCount(): Int {
        return drawList.size
    }

    inner class ViewHolder(private val binding: DrawCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(sayisalSuperModel: SayisalSuperModel) {
            binding.model = sayisalSuperModel
            binding.detailButton.setOnClickListener {
                onClickedDetail?.invoke(sayisalSuperModel)
            }
        }
    }

}