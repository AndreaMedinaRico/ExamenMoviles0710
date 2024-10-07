package com.example.kotlin.examenmoviles0710.framework.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin.examenmoviles0710.R
import com.example.kotlin.examenmoviles0710.data.network.models.Planets.Item
import com.example.kotlin.examenmoviles0710.databinding.ItemPlanetBinding

class PlanetViewHolder(private val binding: ItemPlanetBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(planet: Item) {
        // Establecer el nombre del planeta
        binding.TVName.text = planet.name

        // Establecer la descripción del planeta
        binding.TVDescription.text = planet.description

        // Cargar la imagen del planeta usando Glide
        Glide.with(binding.root.context)
            .load(planet.image)
            .into(binding.IVPlanetImage)
    }
}
