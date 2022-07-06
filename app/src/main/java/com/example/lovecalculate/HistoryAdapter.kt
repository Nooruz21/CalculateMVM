package com.example.lovecalculate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculate.databinding.ItemHistoryBinding
import com.example.lovecalculate.network.model.LoveModel

class HistoryAdapter(val list: List<LoveModel>) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {



    class HistoryViewHolder(private val binding:ItemHistoryBinding):RecyclerView.ViewHolder(binding.root){
        fun onBind(loveModel: LoveModel) {
            binding.fName.text=loveModel.firstName
            binding.sName.text=loveModel.secondName
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(ItemHistoryBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
       holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}