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

class CharacterFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CharacterViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CharacterAdapter
    private lateinit var data: ArrayList<Item>

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

    private fun initializeComponents(root: View) {
        recyclerView = root.findViewById(R.id.Characters_List)

        // Inicializa el adaptador con la lista vacía y el contexto del fragmento
        adapter = CharacterAdapter(data, requireContext())

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }

    private fun initializeObservers() {
        viewModel.characterItemsLiveData.observe(viewLifecycleOwner) { items ->
            data.clear()
            data.addAll(items)
            adapter.notifyDataSetChanged() // Notifica al adaptador que los datos han cambiado
        }
    }
}
