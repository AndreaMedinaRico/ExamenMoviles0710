package com.example.kotlin.examenmoviles0710.data.network.models.Characters

data class Meta(
    val currentPage: Int,
    val itemCount: Int,
    val itemsPerPage: Int,
    val totalItems: Int,
    val totalPages: Int
)