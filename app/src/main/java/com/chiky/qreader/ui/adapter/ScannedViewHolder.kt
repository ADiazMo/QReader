package com.chiky.qreader.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.chiky.qreader.data.model.Scanned
import com.bumptech.glide.Glide
import com.chiky.qreader.databinding.ItemScannedBinding

class ScannedViewHolder(view:View): RecyclerView.ViewHolder(view) {
    val binding = ItemScannedBinding.bind(view)

    fun render(scannedModel: Scanned, onClickListener:(Scanned) -> Unit){

        binding.tvTitulo.text = scannedModel.title
        binding.tvData.text = scannedModel.data
        //Glide.with(binding.ivPhoto.context).load(pokemonModel.photo).into(binding.ivPhoto)

        //click in the image
        /*
        binding.ivPhoto.setOnClickListener {
            Toast.makeText(
                binding.ivPhoto.context,
                pokemonModel.name,
                Toast.LENGTH_SHORT
            ).show()
        }
        */
        //click in the cell
        /*
        itemView.setOnClickListener {
            Toast.makeText(
                binding.ivPhoto.context,
                pokemonModel.name,
                Toast.LENGTH_SHORT
            ).show()
        }
        */

        //click pass to object
        itemView.setOnClickListener { onClickListener(scannedModel) }
    }
}