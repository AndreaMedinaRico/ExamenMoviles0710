package com.example.kotlin.examenmoviles0710.framework.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.examenmoviles0710.databinding.FragmentPlanetBinding
import com.example.kotlin.examenmoviles0710.framework.viewmodel.PlanetViewModel
import com.example.kotlin.examenmoviles0710.framework.adapters.PlanetAdapter

class PlanetFragment : Fragment() {
    private var _binding: FragmentPlanetBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: PlanetViewModel
    private lateinit var adapter: PlanetAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlanetBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModel = ViewModelProvider(this)[PlanetViewModel::class.java]
        setupRecyclerView()
        setupObservers()

        // Llamar a la función para obtener los planetas
        viewModel.getPlanets()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {
        adapter = PlanetAdapter(requireContext())
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.planetList.observe(viewLifecycleOwner) { planets ->
            adapter.updatePlanets(planets)
        }
    }
}
