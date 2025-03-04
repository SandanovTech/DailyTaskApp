package com.example.dailytaskapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dailytaskapp.databinding.TaskCardBinding
import com.example.dailytaskapp.domain.model.Task
import java.time.format.DateTimeFormatter

class TaskAdapter(
    private val onTaskClick: (String) -> Unit,
) : ListAdapter<Task, TaskAdapter.TaskViewHolder>(TaskDiffCallback()) {

    inner class TaskViewHolder(private val binding: TaskCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Task) {
            val formatter = DateTimeFormatter.ofPattern("d MMMM yyyy, HH:mm")
            binding.title.text = item.title
            binding.createdTime.text = item.data.format(formatter)
            binding.root.setOnClickListener {
                onTaskClick(item.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = TaskCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}