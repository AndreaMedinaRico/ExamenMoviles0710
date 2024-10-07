package com.example.kotlin.examenmoviles0710.framework.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin.examenmoviles0710.R
import com.example.kotlin.examenmoviles0710.data.network.models.CharacterResponse
import com.example.kotlin.examenmoviles0710.data.network.models.Item
import com.example.kotlin.examenmoviles0710.databinding.ItemCharacterBinding

class CharacterViewHolder(private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Item) {
        binding.TVName.text = item.name
        Glide.with(binding.IVPhoto.context).load(item.image).into(binding.IVPhoto)

        binding.TVKi.text = binding.root.context.getString(R.string.ki, item.ki)
        binding.TVMaxKi.text = binding.root.context.getString(R.string.maxKi, item.maxKi)
        binding.TVRace.text = binding.root.context.getString(R.string.race, item.race)
        binding.TVGender.text = binding.root.context.getString(R.string.gender, item.gender)
    }
}