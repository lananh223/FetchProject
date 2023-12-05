package com.example.fetchproject.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fetchproject.databinding.FragmentItemBinding
import com.example.fetchproject.viewmodel.ItemViewModel

class ItemFragment : Fragment() {

    private val viewmodel: ItemViewModel by viewModels()
    private var _binding: FragmentItemBinding? = null
    private val binding get() = _binding!!
    private var itemAdapter = ItemAdapter(emptyList())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Set up Layout Manager for RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = itemAdapter

        //Observe LiveData from ViewModel
        viewmodel.itemLiveData.observe(viewLifecycleOwner) { result ->
            itemAdapter.itemDataList = result
            itemAdapter.notifyDataSetChanged()
        }
        viewmodel.getDataFromRepository()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}