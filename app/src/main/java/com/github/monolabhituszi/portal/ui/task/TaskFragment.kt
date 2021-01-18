package com.github.monolabhituszi.portal.ui.task

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.monolabhituszi.portal.R
import com.github.monolabhituszi.portal.TaskActivity
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
                    // sample start activity
                    val item = taskViewModel.list.value?.get(index)

                    val bundle = Bundle()
                    bundle.putString("title", item?.title)
                    bundle.putString("description", item?.description)
                    bundle.putString("remaining", item?.remaining)

                    val intent = Intent(context, TaskActivity::class.java)
                    intent.putExtra("DATA", bundle)
                    startActivity(intent)
                    // sample add list
                    val count = (taskViewModel.list.value?.size ?: 0) + 1
                    taskViewModel.add(
                        SampleTaskModel(
                            title = "タスク$count",
                            description = "タスク${count}だよー",
                            remaining = "あと${count}日だよー"
                        )
                    )
                }
            }
        )

        binding.recyclerView.also {
            it.setController(controller)
        }

        taskViewModel.add(
            SampleTaskModel(
                title = "タスク1",
                description = "タスク1だよー",
                remaining = "あと1日だよー"
            )
        )

        taskViewModel.list.observe(viewLifecycleOwner, Observer(controller::setData))
    }
}
