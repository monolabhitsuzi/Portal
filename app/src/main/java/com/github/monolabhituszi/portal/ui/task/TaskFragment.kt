package com.github.monolabhituszi.portal.ui.task

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.monolabhituszi.portal.R
import com.github.monolabhituszi.portal.databinding.FragmentTaskBinding
import com.github.monolabhituszi.portal.model.SampleTaskModel
import com.github.monolabhituszi.portal.ui.task.controller.TaskController

class TaskFragment : Fragment(R.layout.fragment_task) {
    private lateinit var binding: FragmentTaskBinding
    private lateinit var taskViewModel: TaskViewModel
    private lateinit var controller: TaskController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // binding
        binding = FragmentTaskBinding.bind(view)

        // view model
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)

        // lifecycle
        binding.lifecycleOwner = this

        controller = TaskController(
            object : TaskController.Listener {
                override fun onClickItem(index: Int) {
                    Toast.makeText(activity, "$index clicked!", Toast.LENGTH_SHORT).show()
                }
            }
        )

        binding.recyclerView.also {
            it.setController(controller)
        }

        val sampleData = listOf<SampleTaskModel>(
            SampleTaskModel(
                title = "タスク１",
                description = "タスク１だよー",
                remaining = "あと2日だよー"
            ),
            SampleTaskModel(
                title = "タスク2",
                description = "タスク2だよー",
                remaining = "手遅れだよー"
            )
        )

        controller.setData(sampleData)
    }
}
