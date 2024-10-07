package com.example.kotlin.examenmoviles0710.domain

import com.example.kotlin.examenmoviles0710.data.network.models.Planets.Item
import com.example.kotlin.examenmoviles0710.data.repositories.PlanetRepository

class PlanetRequirement {
    private val repository = PlanetRepository()

    suspend fun getPlanets(): List<Item> {
        return repository.getPlanets()
    }

    suspend fun getPlanetById(id: Int): Item {
        return repository.getPlanetById(id)
    }

}