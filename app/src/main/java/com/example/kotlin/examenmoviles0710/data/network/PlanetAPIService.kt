package com.example.kotlin.examenmoviles0710.data.network

import com.example.kotlin.examenmoviles0710.data.network.models.Planets.Item
import com.example.kotlin.examenmoviles0710.data.network.models.Planets.PlanetResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PlanetAPIService {
    @GET("planets")
    suspend fun getPlanets(
    ): PlanetResponse

    @GET("planets/{id}")
    suspend fun getPlanetById(
        @Path("id") planetId: Int
    ): Item
}
