package com.example.dailytaskapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dailytaskapp.databinding.FragmentTaskBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.time.LocalDateTime

class TaskFragment : Fragment() {
    private val viewModel: TaskViewModel by viewModel()
    private var _binding: FragmentTaskBinding? = null
    private val binding get() = _binding!!
    private var taskId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            taskId = it.getString("taskId")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (taskId == null) {
            showNewTaskUI()
        } else {
            showSelectedTaskUI()
        }
    }

    private fun showSelectedTaskUI() {
        viewModel.getSelectedTask(taskId!!)
        viewModel.selectedTask.observe(viewLifecycleOwner) { task ->
            binding.label.setText(task.title)
            binding.description.setText(task.description)
            binding.saveBtn.setOnClickListener {
                val updatedTask = task.copy(
                    title = binding.label.text.toString(),
                    description = binding.description.text.toString(),
                    data = LocalDateTime.now()
                )
                viewModel.updateCurrentTask(updatedTask)
            }
        }
    }

    private fun showNewTaskUI() {
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