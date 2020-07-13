package com.github.monolabhituszi.portal.ui.task

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.monolabhituszi.portal.R
import com.github.monolabhituszi.portal.databinding.FragmentTaskBinding

class TaskFragment : Fragment(R.layout.fragment_task) {
    private lateinit var binding: FragmentTaskBinding
    private lateinit var taskViewModel: TaskViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // binding
        binding = FragmentTaskBinding.bind(view)

        // view model
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        taskViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textTask.text = it
        })

        // lifecycle
        binding.lifecycleOwner = this
    }
}
