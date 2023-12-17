package com.example.aplicativoteste.UI.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplicativoteste.UI.adapter.ListRedditAdapter
import com.example.aplicativoteste.databinding.FragmentListBinding
import com.example.aplicativoteste.viewModels.ListViewModel

class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private val listVM: ListViewModel by viewModels()
    private lateinit var adapter: ListRedditAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentListBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ListRedditAdapter()

        binding.recyclerListReddit.layoutManager = LinearLayoutManager(context)
        binding.recyclerListReddit.adapter = adapter

        setObserver()
    }

    fun setObserver(){
        listVM.getTopicList().observe(viewLifecycleOwner) {
            adapter.updateDietList(it)
            binding.progressBar.visibility = View.GONE
        }
    }
}