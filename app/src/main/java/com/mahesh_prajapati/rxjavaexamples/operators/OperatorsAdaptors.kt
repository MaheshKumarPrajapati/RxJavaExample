package com.mahesh_prajapati.rxjavaexamples.operators

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mahesh_prajapati.rxjavaexamples.databinding.AdaptorOperatorBinding

class OperatorsAdaptors : RecyclerView.Adapter<MainViewHolder>() {
    var names = mutableListOf<String>()
    fun setOperatorNameList(names: List<String>) {
        this.names = names.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdaptorOperatorBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val name = names[position]
        holder.binding.operatorName.text = name
    }
    override fun getItemCount(): Int {
        return names.size
    }
}
class MainViewHolder(val binding: AdaptorOperatorBinding) : RecyclerView.ViewHolder(binding.root) {
}
