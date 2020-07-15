package com.github.monolabhituszi.portal.ui.task

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.monolabhituszi.portal.R
import com.github.monolabhituszi.portal.databinding.FragmentTaskBinding
import com.github.monolabhituszi.portal.model.SampleModel
import com.github.monolabhituszi.portal.ui.task.animation.ZoomOutPageTransformer

class TaskFragment : Fragment(R.layout.fragment_task) {
    private lateinit var binding: FragmentTaskBinding
    private lateinit var taskViewModel: TaskViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // binding
        binding = FragmentTaskBinding.bind(view)

        // view model
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)

        // lifecycle
        binding.lifecycleOwner = this

        val adapter = TaskAdapter()

        val sampleItem = listOf(
            SampleModel(
                title = "月曜日",
                description = "月曜日の時間割"
            ),
            SampleModel(
                title = "火曜日",
                description = "火曜日の時間割"
            ),
            SampleModel(
                title = "水曜日",
                description = "水曜日の時間割"
            ),
            SampleModel(
                title = "木曜日",
                description = "木曜日の時間割"
            ),
            SampleModel(
                title = "金曜日",
                description = "金曜日の時間割"
            )
        )

        binding.viewpager.offscreenPageLimit = 2
        binding.viewpager.setPageTransformer(ZoomOutPageTransformer())

        binding.viewpager.apply {
            this.adapter = adapter
            adapter.setItem(sampleItem)
        }
    }
}
