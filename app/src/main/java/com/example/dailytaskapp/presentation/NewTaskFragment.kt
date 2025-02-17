package com.example.dailytaskapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import com.example.dailytaskapp.databinding.FragmentNewTaskBinding
import kotlinx.coroutines.launch
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
        binding.saveBtn.setOnClickListener {
            if (binding.label.text.isNotBlank() && binding.inputText.text.isNotBlank()) {
                viewModel.viewModelScope.launch {
                    viewModel.createTask(
                        binding.label.text.toString(),
                        binding.inputText.text.toString(),
                        currentTime.toString()
                    )
                }
            }
        }
    }
}