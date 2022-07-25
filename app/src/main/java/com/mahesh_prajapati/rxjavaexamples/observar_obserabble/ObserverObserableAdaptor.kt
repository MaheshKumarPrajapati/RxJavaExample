package com.mahesh_prajapati.rxjavaexamples.observar_obserabble

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mahesh_prajapati.rxjavaexamples.databinding.AdaptorObserverObserableBinding
import com.mahesh_prajapati.rxjavaexamples.utils.CellClickListener

class ObserverObserableAdaptor(val names: List<String>,val cellClickListener: CellClickListener) : RecyclerView.Adapter<ObserverObserableAdaptor.ViewHolder>() {

    // create an inner class with name ViewHolder
    // It takes a view argument, in which pass the generated class of single_item.xml
    // ie SingleItemBinding and in the RecyclerView.ViewHolder(binding.root) pass it like this
    inner class ViewHolder(val binding: AdaptorObserverObserableBinding) : RecyclerView.ViewHolder(binding.root)

    // inside the onCreateViewHolder inflate the view of SingleItemBinding
    // and return new ViewHolder object containing this layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdaptorObserverObserableBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    // bind the items with each item
    // of the list languageList
    // which than will be
    // shown in recycler view
    // to keep it simple we are
    // not setting any image data to view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(names[position]){
                binding.observarObserableName.text = this
            }
        }
        holder.binding.observarObserableName.setOnClickListener { cellClickListener.onCellClickListener(position) }
    }

    // return the size of languageList
    override fun getItemCount(): Int {
        return names.size
    }
}