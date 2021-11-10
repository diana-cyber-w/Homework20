package com.example.homework_20.presentation

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_20.data.BottomSheetData
import com.example.homework_20.data.DataSource

class BottomSheetAdapter : RecyclerView.Adapter<BottomSheetViewHolder>() {

    private var items: List<BottomSheetData> = mutableListOf()
    private var itemClickListener: ((BottomSheetData) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BottomSheetViewHolder {
        val viewHolder = BottomSheetViewHolder.from(parent)

        viewHolder.setItemOnclickListener { bottomSheetData ->
            itemClickListener?.invoke(bottomSheetData)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: BottomSheetViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount() = items.size

    fun submitList(data: List<BottomSheetData>) {
        items = data
        notifyDataSetChanged()
    }

    fun setItemOnclickListener(listener: (BottomSheetData) -> Unit) {
        itemClickListener = listener
    }
}