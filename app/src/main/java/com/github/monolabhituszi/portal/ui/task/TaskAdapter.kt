package com.github.monolabhituszi.portal.ui.task

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.monolabhituszi.portal.databinding.ViewTaskBinding
import com.github.monolabhituszi.portal.model.SampleModel

internal class TaskAdapter : RecyclerView.Adapter<TaskViewHolder>() {
    private var list: List<SampleModel> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewTaskBinding.inflate(inflater, parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setItem(list: List<SampleModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size
}
