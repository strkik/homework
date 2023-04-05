package com.example.homework.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework.R
import com.example.homework.listener.ItemListener
import com.example.homework.model.ItemsModel

class ItemsAdapter(
    private val itemListener: ItemListener
) : RecyclerView.Adapter<ItemsViewHolder>() {
    private var listItems = mutableListOf<ItemsModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {

        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_fruit,parent,false)
        return ItemsViewHolder(view,itemListener)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bind(listItems[position])

    }
    fun submitList(list: List<ItemsModel>){
        this.listItems = list.toMutableList()
    }
}