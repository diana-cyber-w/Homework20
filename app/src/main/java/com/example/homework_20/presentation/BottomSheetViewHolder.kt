package com.example.homework_20.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_20.R
import com.example.homework_20.data.BottomSheetData
import kotlinx.android.synthetic.main.recycler_view.view.*


class BottomSheetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun from(parent: ViewGroup): BottomSheetViewHolder {
            return BottomSheetViewHolder(
                LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.recycler_view, parent, false)
            )
        }
    }

    private val smartphoneModelTextView: TextView by lazy { itemView.smartphoneModel }

    private var itemClickListener: ((BottomSheetData) -> Unit)? = null

    fun bindView(item: BottomSheetData) {
        smartphoneModelTextView.text = item.smartphoneModel

        itemView.setOnClickListener {
            itemClickListener?.invoke(item)
        }
    }

    fun setItemOnclickListener(listener: (BottomSheetData) -> Unit) {
        itemClickListener = listener
    }
}