package com.example.dailytaskapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.dailytaskapp.databinding.FragmentSelectedTaskBinding
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import java.time.LocalDateTime

class SelectedTaskFragment : Fragment() {
    private val viewModel: SelectedTaskViewModel by inject()
    private var _binding: FragmentSelectedTaskBinding? = null
    private val binding get() = _binding!!
    private val args: SelectedTaskFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSelectedTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val taskId = args.taskId
        viewModel.getSelectedTask(taskId)
        viewModel.selectedTask.observe(viewLifecycleOwner) { task ->
            binding.label.setText(task.title)
            binding.inputText.setText(task.description)
            binding.saveBtn.setOnClickListener {
                val updatedTask = task.copy(
                    title = binding.label.text.toString(),
                    description = binding.inputText.text.toString(),
                    data = LocalDateTime.now()
                )
                viewModel.updateCurrentTask(updatedTask)
            }
        }
    }
}