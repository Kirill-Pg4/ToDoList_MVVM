package com.example.todolist_mvvm.ui.tasks

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist_mvvm.data.Task
import com.example.todolist_mvvm.databinding.ItemTaskBinding

class TasksAdapter : ListAdapter<Task,TasksAdapter.TaskViewHolder>(DiffCallback()) {

    class TaskViewHolder(private val binding: ItemTaskBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(task: Task){
            binding.apply {
                checkBoxCompleted.isChecked = task.completed
                textView.text = task.name
                textView.paint.isStrikeThruText = task.completed
                labrlPriority.isVisible = task.important
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    class DiffCallback : DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task) =
                oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Task, newItem: Task) =
            oldItem == newItem
    }

}