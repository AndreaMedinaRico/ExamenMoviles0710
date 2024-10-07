package com.example.kotlin.examenmoviles0710.data.repositories

import com.example.kotlin.examenmoviles0710.data.network.PlanetAPIService
import com.example.kotlin.examenmoviles0710.data.network.PlanetNetworkModuleDI
import com.example.kotlin.examenmoviles0710.data.network.models.Planets.Item

class PlanetRepository {
    private lateinit var api: PlanetAPIService

    suspend fun getPlanets(): List<Item> {
        api = PlanetNetworkModuleDI()

        val response = api.getPlanets()
        return response.items
    }

    suspend fun getPlanetById(planetId: Int): Item {
        return api.getPlanetById(planetId)
    }
}
