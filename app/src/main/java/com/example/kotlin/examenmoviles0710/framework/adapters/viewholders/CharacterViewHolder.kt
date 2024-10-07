package com.example.kotlin.examenmoviles0710.framework.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin.examenmoviles0710.data.network.models.CharacterResponse
import com.example.kotlin.examenmoviles0710.data.network.models.Item
import com.example.kotlin.examenmoviles0710.databinding.ItemCharacterBinding

class CharacterViewHolder(private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Item) {
        binding.TVName.text = item.name
        Glide.with(binding.IVPhoto.context).load(item.image).into(binding.IVPhoto)
    }
}