package com.example.kotlin.examenmoviles0710.framework.views.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.examenmoviles0710.data.network.models.CharacterResponse
import com.example.kotlin.examenmoviles0710.data.network.models.Item
import com.example.kotlin.examenmoviles0710.data.repositories.CharacterRepository
import com.example.kotlin.examenmoviles0710.databinding.ActivityMainBinding
import com.example.kotlin.examenmoviles0710.framework.adapters.CharacterAdapter
import com.example.kotlin.examenmoviles0710.framework.viewmodel.CharacterViewModel
import com.example.kotlin.examenmoviles0710.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity(): AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter : CharacterAdapter = CharacterAdapter()
    private lateinit var data:ArrayList<CharacterResponse>

    private val viewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()

        initializeObservers()
        viewModel.getCharacters()
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setUpRecyclerView(items: List<Item>){
        binding.RVCharacter.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.RVCharacter.layoutManager = linearLayoutManager

        adapter.CharacterAdapter(items, this)
        binding.RVCharacter.adapter = adapter
    }

    private fun initializeObservers(){
        viewModel.characterItemsLiveData.observe(this){ items ->
            setUpRecyclerView(items)
        }
    }

}