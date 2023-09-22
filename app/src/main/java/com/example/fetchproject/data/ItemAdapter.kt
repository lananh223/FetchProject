package com.example.fetchproject.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchproject.R

class ItemAdapter(private val itemDataList: List<ItemData>) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val id: TextView = view.findViewById(R.id.item_id)
        val listId: TextView = view.findViewById(R.id.list_id)
        val name: TextView? = view.findViewById(R.id.item_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text = itemDataList[position].id.toString()
        holder.listId.text = itemDataList[position].listId.toString()
        holder.name?.text = itemDataList[position].name
    }

    override fun getItemCount(): Int = itemDataList.size
}