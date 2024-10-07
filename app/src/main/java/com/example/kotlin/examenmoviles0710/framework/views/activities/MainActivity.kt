package com.example.kotlin.examenmoviles0710.framework.views.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.examenmoviles0710.data.network.models.CharacterResponse
import com.example.kotlin.examenmoviles0710.data.network.models.Item
import com.example.kotlin.examenmoviles0710.data.repositories.CharacterRepository
import com.example.kotlin.examenmoviles0710.databinding.ActivityMainBinding
import com.example.kotlin.examenmoviles0710.framework.adapters.CharacterAdapter
import com.example.kotlin.examenmoviles0710.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity(): AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter : CharacterAdapter = CharacterAdapter()
    private lateinit var data:ArrayList<CharacterResponse>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        getCharacters()
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setUpRecyclerView(dataForList: ArrayList<CharacterResponse>){
        binding.RVCharacter.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.RVCharacter.layoutManager = linearLayoutManager

        adapter.CharacterAdapter(dataForList.map { it.items.first() }, this)
        binding.RVCharacter.adapter = adapter
    }

    private fun getCharacters(){
        CoroutineScope(Dispatchers.IO).launch {
            val characterRepository = CharacterRepository()
            val result: CharacterResponse? = characterRepository.getCharacters(1, Constants.MAX_CHARACTER_NUMBER)
            Log.d("Salida", result?.items?.get(1)?.name.toString())

            CoroutineScope(Dispatchers.Main).launch {
                result?.let {
                    val characterList = ArrayList<CharacterResponse>()
                    // Mapear los `items` a una nueva lista de CharacterResponse
                    for (item in it.items) {
                        characterList.add(CharacterResponse(listOf(item), it.links, it.meta))
                    }
                    setUpRecyclerView(characterList)  // Usar la lista mapeada
                }
            }
        }
    }

}