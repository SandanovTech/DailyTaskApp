package com.example.dailytaskapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dailytaskapp.databinding.FragmentNewTaskBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.time.LocalDateTime

class NewTaskFragment : Fragment() {
    private val viewModel: NewTaskViewModel by viewModel()
    private var _binding: FragmentNewTaskBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentNewTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currentTime = LocalDateTime.now()
        val label = binding.label.text
        val description = binding.description.text
        binding.saveBtn.setOnClickListener {
            if (label.isNotBlank() && description.isNotBlank()) {
                viewModel.createTask(
                    label.toString(),
                    description.toString(),
                    currentTime
                )
            }
        }
    }
}