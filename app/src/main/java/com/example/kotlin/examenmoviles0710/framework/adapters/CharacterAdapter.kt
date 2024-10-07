package com.example.kotlin.examenmoviles0710.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.examenmoviles0710.data.network.models.Characters.Item
import com.example.kotlin.examenmoviles0710.databinding.ItemCharacterBinding
import com.example.kotlin.examenmoviles0710.framework.adapters.viewholders.CharacterViewHolder

class CharacterAdapter(private val data: List<Item>, private val context: Context) : RecyclerView.Adapter<CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
