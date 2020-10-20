package com.github.monolabhituszi.portal.ui.task.controller

import com.airbnb.epoxy.TypedEpoxyController
import com.github.monolabhituszi.portal.itemEmpty
import com.github.monolabhituszi.portal.itemTask
import com.github.monolabhituszi.portal.model.SampleTaskModel

class TaskController(
    private val listener: Listener
) : TypedEpoxyController<List<SampleTaskModel>>() {
    override fun buildModels(data: List<SampleTaskModel>?) {
        requireNotNull(data)
        if (data.isEmpty()) {
            itemEmpty {
                id("empty")
            }
        }

        data.forEachIndexed { index, sampleModel ->
            val title = sampleModel.title
            val description = sampleModel.description
            val remaining = sampleModel.remaining

            itemTask {
                id("task")
                title(title)
                description(description)
                remaining(remaining)
                listener { _ -> listener.onClickItem(index) }
            }
        }
    }

    interface Listener {
        fun onClickItem(index: Int)
    }
}
