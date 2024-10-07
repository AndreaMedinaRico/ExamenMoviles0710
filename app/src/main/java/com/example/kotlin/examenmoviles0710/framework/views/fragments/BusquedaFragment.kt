package com.example.kotlin.examenmoviles0710.framework.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.examenmoviles0710.data.network.models.Item
import com.example.kotlin.examenmoviles0710.databinding.FragmentSearchBinding
import com.example.kotlin.examenmoviles0710.framework.adapters.CharacterAdapter
import com.example.kotlin.examenmoviles0710.framework.viewmodel.SearchViewModel

class BusquedaFragment: Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[SearchViewModel::class.java]

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initializeListeners()
        initializeObservers()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initializeListeners() {
        binding.searchButton.setOnClickListener {
            val name = binding.searchEditText.text.toString()
            if (name.isNotEmpty()) {
                viewModel.searchCharacterByName(name)
            } else {
                Toast.makeText(context, "Enter a name", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun initializeObservers() {
        viewModel.searchResults.observe(viewLifecycleOwner) { items ->
            if (items.isEmpty()) {
                Toast.makeText(context, "No characters found", Toast.LENGTH_SHORT).show()
            } else {
                setUpRecyclerView(items) // Actualizar el RecyclerView con los resultados
            }
        }
    }

    private fun setUpRecyclerView(items: List<Item>) {
        binding.CharactersList.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
        binding.CharactersList.layoutManager = linearLayoutManager

        val adapter = CharacterAdapter(items, requireContext())
        binding.CharactersList.adapter = adapter
    }

}