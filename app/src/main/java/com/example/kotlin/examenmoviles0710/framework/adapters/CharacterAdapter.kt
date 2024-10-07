package com.example.kotlin.examenmoviles0710.framework.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.examenmoviles0710.databinding.ItemCharacterBinding
import com.example.kotlin.examenmoviles0710.framework.adapters.viewholders.CharacterViewHolder

class CharacterAdapter: RecyclerView.Adapter<CharacterViewHolder>() {
    private var data: List<CharacterResponse> = emptyList()

    fun CharacterAdapter(basicData : ArrayList<CharacterResponse>){
        this.data = basicData
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CharacterViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return data.size
    }
}