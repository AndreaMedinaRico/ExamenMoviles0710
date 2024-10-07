package com.example.kotlin.examenmoviles0710.framework.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.examenmoviles0710.data.network.models.Planets.Item
import com.example.kotlin.examenmoviles0710.data.network.models.Planets.PlanetResponse
import com.example.kotlin.examenmoviles0710.data.repositories.PlanetRepository
import com.example.kotlin.examenmoviles0710.domain.PlanetRequirement
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlanetViewModel : ViewModel() {
    val planetList = MutableLiveData<List<Item>>()
    private val repository = PlanetRepository()

    private val requirement = PlanetRequirement()

    fun getPlanets() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                // Obtener la lista de todos los planetas
                val planets = requirement.getPlanets()
                val detailedPlanets = planets.map { planet ->
                    // Obtener detalles de cada planeta por su ID
                    requirement.getPlanetById(planet.id)
                }
                planetList.postValue(detailedPlanets)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
