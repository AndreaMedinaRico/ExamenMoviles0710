package com.example.kotlin.examenmoviles0710.framework.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.examenmoviles0710.data.network.models.Item
import com.example.kotlin.examenmoviles0710.databinding.ItemCharacterBinding
import com.example.kotlin.examenmoviles0710.framework.adapters.viewholders.CharacterViewHolder
import com.example.kotlin.examenmoviles0710.framework.views.activities.MainActivity

class CharacterAdapter : RecyclerView.Adapter<CharacterViewHolder>() {
    private var data: List<Item> = emptyList() // Cambiar a List<Item>

    // Cambiar el constructor para aceptar una lista de Item
    fun CharacterAdapter(basicData: List<Item>, context: MainActivity) {
        this.data = basicData
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item) // Pasar el objeto Item al ViewHolder
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
