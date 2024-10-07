package com.example.kotlin.examenmoviles0710.framework.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.examenmoviles0710.data.network.models.CharacterResponse
import com.example.kotlin.examenmoviles0710.data.network.models.Item
import com.example.kotlin.examenmoviles0710.data.repositories.CharacterRepository
import com.example.kotlin.examenmoviles0710.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharacterViewModel: ViewModel() {
    val characterItemsLiveData = MutableLiveData<List<Item>>()

    fun getCharacters(){
        viewModelScope.launch(Dispatchers.IO) {
            val characterRepository = CharacterRepository()
            val result: List<Item> = characterRepository.getCharacters(Constants.MAX_CHARACTER_NUMBER)
            Log.d("Salida", result?.get(1)?.name.toString())

            CoroutineScope(Dispatchers.Main).launch {
                    // Publicar la lista de Items en el LiveData
                    characterItemsLiveData.postValue(result)
            }
        }
    }
}