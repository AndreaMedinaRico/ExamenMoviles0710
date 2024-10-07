package com.example.kotlin.examenmoviles0710.data.network.models.Planets

import com.example.kotlin.examenmoviles0710.data.network.models.Characters.Item

data class Item(
    val deletedAt: Any,
    val description: String,
    val id: Int,
    val image: String,
    val isDestroyed: Boolean,
    val name: String,
    val characters: List<Item>
)