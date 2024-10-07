package com.example.kotlin.examenmoviles0710.framework.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.examenmoviles0710.databinding.ActivityMainBinding
import com.example.kotlin.examenmoviles0710.framework.adapters.CharacterAdapter

class MainActivity(): AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter : CharacterAdapter = CharacterAdapter()
    private lateinit var data:ArrayList<CharacterResponse>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        data = testData()
        setUpRecyclerView(data)
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun testData():ArrayList<CharacterResponse>{
        var result = ArrayList<CharacterResponse>()

        result.add(CharacterResponse("bulbasaur",""))
        result.add(CharacterResponse("charmander",""))
        result.add(CharacterResponse("squirtle",""))

        return result
    }

    private fun setUpRecyclerView(dataForList:ArrayList<CharacterResponse>){
        binding.RVPokemon.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)
        binding.RVPokemon.layoutManager = linearLayoutManager
        adapter.CharacterAdapter(dataForList)
        binding.RVPokemon.adapter = adapter
    }
}