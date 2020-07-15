package com.github.monolabhituszi.portal.ui.timetable

import androidx.recyclerview.widget.RecyclerView
import com.github.monolabhituszi.portal.databinding.ViewTaskBinding
import com.github.monolabhituszi.portal.model.SampleModel

internal class TimetableViewHolder(private val binding: ViewTaskBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: SampleModel) {
        binding.apply {
            model = item
            executePendingBindings()
        }
    }
}
