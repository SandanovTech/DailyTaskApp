package com.example.dailytaskapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dailytaskapp.R
import com.example.dailytaskapp.databinding.FragmentMainBinding
import org.koin.android.ext.android.inject


class MainFragment : Fragment() {
    private val viewModel: MainViewModel by inject()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var taskRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        binding.floatingActionButton.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToNewTaskFragment()
            findNavController().navigate(action)
        }
    }

    private fun setupRecyclerView() {
        taskAdapter = TaskAdapter()
        taskRecyclerView = binding.tasksRv
        taskRecyclerView.adapter = taskAdapter
        taskRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}