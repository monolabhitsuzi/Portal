package com.github.monolabhituszi.portal.ui.task.controller

import com.airbnb.epoxy.TypedEpoxyController
import com.github.monolabhituszi.portal.itemEmpty
import com.github.monolabhituszi.portal.itemTask
import com.github.monolabhituszi.portal.model.SampleModel

class TaskController : TypedEpoxyController<List<SampleModel>>() {
    override fun buildModels(data: List<SampleModel>?) {
        requireNotNull(data)
        if (data.isEmpty()) {
            itemEmpty {
                id("empty")
            }
        }

        data.forEachIndexed { index, sampleModel ->
            val title = sampleModel.title
            val description = sampleModel.description

            itemTask {
                id("task")
                title(title)
                description(description)
            }
        }
    }
}
