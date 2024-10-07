package com.example.kotlin.examenmoviles0710.data.repositories

import com.example.kotlin.examenmoviles0710.data.network.CharacterAPIService
import com.example.kotlin.examenmoviles0710.data.network.NetworkModuleDI
import com.example.kotlin.examenmoviles0710.data.network.models.CharacterResponse

class CharacterRepository {
    private lateinit var api: CharacterAPIService

    suspend fun getCharacters(page: Int, limit: Int): CharacterResponse? {
        api = NetworkModuleDI()
        return try{
            api.getCharacters(page, limit)
        } catch (e:java.lang.Exception) {
            e.printStackTrace()
            null
        }
    }
}