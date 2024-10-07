package com.example.kotlin.examenmoviles0710.framework.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.examenmoviles0710.data.network.models.Characters.Item
import com.example.kotlin.examenmoviles0710.data.repositories.CharacterRepository
import com.example.kotlin.examenmoviles0710.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel: ViewModel() {
    val searchResults = MutableLiveData<List<Item>>()
    private val repository = CharacterRepository()
    private var allCharacters: List<Item> = listOf()

    init {
        // Cargar todos los personajes cuando se inicializa el ViewModel
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // Descargamos todos los personajes y los almacenamos en allCharacters
                allCharacters = repository.getCharacters(Constants.MAX_CHARACTER_NUMBER)
            } catch (e: Exception) {
                e.printStackTrace()

            }
        }
    }

    // Función para buscar personajes por nombre en la lista ya cargada
    fun searchCharacterByName(name: String) {
        if (allCharacters.isEmpty()) {
            return
        }

        // Filtrar la lista para encontrar personajes que coincidan con el nombre
        val result = allCharacters.filter { it.name.contains(name, ignoreCase = true) }
        searchResults.postValue(result) // Actualiza el LiveData con la lista de resultados
    }

}