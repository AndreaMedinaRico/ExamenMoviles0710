package com.example.kotlin.examenmoviles0710.framework.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.examenmoviles0710.R
import com.example.kotlin.examenmoviles0710.data.network.models.Item
import com.example.kotlin.examenmoviles0710.databinding.FragmentListBinding
import com.example.kotlin.examenmoviles0710.framework.adapters.CharacterAdapter
import com.example.kotlin.examenmoviles0710.framework.viewmodel.CharacterViewModel

class CharacterFragment: Fragment() {
    private var _binding: FragmentListBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: CharacterViewModel

    private lateinit var recyclerView: RecyclerView
    private val adapter : CharacterAdapter = CharacterAdapter()
    private lateinit var data:ArrayList<Item>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[CharacterViewModel::class.java]

        _binding = FragmentListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        data = ArrayList()

        initializeComponents(root)
        initializeObservers()
        viewModel.getCharacters()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initializeComponents(root:View){
        recyclerView = root.findViewById(R.id.Characters_List)
    }

    private fun initializeObservers(){
        viewModel.characterItemsLiveData.observe(viewLifecycleOwner){ items ->
            setUpRecyclerView(items)
        }
    }

    private fun setUpRecyclerView(items: List<Item>){
        recyclerView.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false)
        recyclerView.layoutManager = linearLayoutManager

        adapter.CharacterAdapter(items, requireContext())
        recyclerView.adapter = adapter
    }
}