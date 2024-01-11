package com.chiky.qreader.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chiky.qreader.R
import com.chiky.qreader.data.model.Scanned


class ScannedAdapter(private val scannedList: List<Scanned>, private val onClickListener:(Scanned)-> Unit): RecyclerView.Adapter<ScannedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScannedViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ScannedViewHolder(layoutInflater.inflate(R.layout.item_scanned, parent, false))
    }

    override fun getItemCount(): Int {
        return scannedList.size
    }

    override fun onBindViewHolder(holder: ScannedViewHolder, position: Int) {
        val item = scannedList[position]
        holder.render(item, onClickListener)
    }
}