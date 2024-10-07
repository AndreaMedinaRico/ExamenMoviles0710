package com.example.kotlin.examenmoviles0710.data.network.models.Planets

data class PlanetResponse(
    val items: List<Item>,
    val links: Links,
    val meta: Meta
)