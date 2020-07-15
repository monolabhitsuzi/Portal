package com.github.monolabhituszi.portal.ui.timetable

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.monolabhituszi.portal.databinding.ViewTaskBinding
import com.github.monolabhituszi.portal.model.SampleModel

internal class TimetableAdapter : RecyclerView.Adapter<TimetableViewHolder>() {
    private var list: List<SampleModel> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimetableViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewTaskBinding.inflate(inflater, parent, false)
        return TimetableViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(holder: TimetableViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun setItem(list: List<SampleModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size
}
