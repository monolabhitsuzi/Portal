package com.github.monolabhituszi.portal.ui.task

import androidx.recyclerview.widget.RecyclerView
import com.github.monolabhituszi.portal.databinding.ViewTaskBinding
import com.github.monolabhituszi.portal.model.SampleModel

internal class TaskViewHolder(private val binding: ViewTaskBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: SampleModel) {
        binding.apply {
            model = item
            executePendingBindings()
        }
    }
}
