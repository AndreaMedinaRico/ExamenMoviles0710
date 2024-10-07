package com.example.kotlin.examenmoviles0710.data.repositories

import com.example.kotlin.examenmoviles0710.data.network.CharacterAPIService
import com.example.kotlin.examenmoviles0710.data.network.NetworkModuleDI
import com.example.kotlin.examenmoviles0710.data.network.models.CharacterResponse
import com.example.kotlin.examenmoviles0710.data.network.models.Item

class CharacterRepository {
    private lateinit var api: CharacterAPIService

    suspend fun getCharacters(limit: Int): List<Item> {
        api = NetworkModuleDI()

        var allCharacters = mutableListOf<Item>()
        var currentPage = 1
        var totalPages = 6

        do {
            val response = try {
                api.getCharacters(currentPage, limit)
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
                null
            }

            response?.let {
                allCharacters.addAll(it.items)
                totalPages = it.meta.totalPages
                currentPage++
            } ?: break

        } while (currentPage <= totalPages)

        return allCharacters
    }

}