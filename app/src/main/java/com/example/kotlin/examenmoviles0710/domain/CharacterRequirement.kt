package com.example.kotlin.examenmoviles0710.framework.requirements

import com.example.kotlin.examenmoviles0710.data.network.models.Characters.Item
import com.example.kotlin.examenmoviles0710.data.repositories.CharacterRepository
import com.example.kotlin.examenmoviles0710.utils.Constants

class CharacterRequirement() {

    private val repository = CharacterRepository()

    suspend fun getCharacters(num: Int): List<Item> {
        return repository.getCharacters(Constants.MAX_CHARACTER_NUMBER)
    }
}
