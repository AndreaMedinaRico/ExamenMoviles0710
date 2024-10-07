package com.example.kotlin.examenmoviles0710.data.network.models

data class CharacterResponse(
    val items: List<Item>,
    val links: Links,
    val meta: Meta
)