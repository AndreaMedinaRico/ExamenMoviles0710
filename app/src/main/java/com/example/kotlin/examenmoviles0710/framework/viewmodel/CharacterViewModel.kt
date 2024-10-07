package com.example.kotlin.examenmoviles0710.framework.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.examenmoviles0710.data.network.models.Characters.Item
import com.example.kotlin.examenmoviles0710.data.repositories.CharacterRepository
import com.example.kotlin.examenmoviles0710.framework.requirements.CharacterRequirement
import com.example.kotlin.examenmoviles0710.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterViewModel: ViewModel() {
    val characterItemsLiveData = MutableLiveData<List<Item>>()

    val characterRequirement = CharacterRequirement()

    fun getCharacters(){
        viewModelScope.launch(Dispatchers.IO) {
            val result: List<Item> = characterRequirement.getCharacters(Constants.MAX_CHARACTER_NUMBER)
            Log.d("Salida", result?.get(1)?.name.toString())

            CoroutineScope(Dispatchers.Main).launch {
                    // Publicar la lista de Items en el LiveData
                    characterItemsLiveData.postValue(result)
            }
        }
    }
}