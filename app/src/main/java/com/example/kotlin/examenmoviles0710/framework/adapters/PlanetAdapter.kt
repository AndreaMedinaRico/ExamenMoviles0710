package com.example.kotlin.examenmoviles0710.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin.examenmoviles0710.R
import com.example.kotlin.examenmoviles0710.data.network.models.Planets.Item
import com.example.kotlin.examenmoviles0710.databinding.ItemPlanetBinding

class PlanetAdapter(private val context: Context) : RecyclerView.Adapter<PlanetAdapter.PlanetViewHolder>() {

    private var planetList: List<Item> = emptyList()

    fun updatePlanets(planets: List<Item>) {
        this.planetList = planets
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanetViewHolder {
        val binding = ItemPlanetBinding.inflate(LayoutInflater.from(context), parent, false)
        return PlanetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlanetViewHolder, position: Int) {
        holder.bind(planetList[position])
    }

    override fun getItemCount(): Int = planetList.size

    inner class PlanetViewHolder(private val binding: ItemPlanetBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(planet: Item) {
            binding.TVName.text = planet.name
            binding.TVDescription.text = planet.description
            Glide.with(binding.root.context)
                .load(planet.image)
                .into(binding.IVPlanetImage)

            if (planet.isDestroyed) {
                binding.TVStatus.text = binding.root.context.getString(R.string.estado, "Destruido")
            } else {
                binding.TVStatus.text = binding.root.context.getString(R.string.estado, "Intacto")
            }

            // Mostrar la lista de personajes en el planet
            val characterNames = planet.characters.joinToString(", ") { it.name }
            if (characterNames.isEmpty()) {
                binding.TVCharacters.text = "No hay."
            } else {
                binding.TVCharacters.text = characterNames
            }
        }
    }
}