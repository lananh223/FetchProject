package com.example.fetchproject.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchproject.databinding.ItemListBinding
import com.example.fetchproject.model.ItemData

class ItemAdapter(var itemDataList: List<ItemData>) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = itemDataList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemData = itemDataList[position]

        holder.binding.id.text = itemData.id.toString()
        holder.binding.listId.text = itemData.listId.toString()
        holder.binding.name.text = itemData.name
    }
}