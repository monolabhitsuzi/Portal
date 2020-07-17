package com.github.monolabhituszi.portal.ui.notify.controller

import com.airbnb.epoxy.TypedEpoxyController
import com.github.monolabhituszi.portal.itemEmpty
import com.github.monolabhituszi.portal.itemNotify
import com.github.monolabhituszi.portal.model.SampleModel

class NotifyController : TypedEpoxyController<List<SampleModel>>() {
    override fun buildModels(data: List<SampleModel>?) {
        requireNotNull(data)
        if (data.isEmpty()) {
            itemEmpty {
                id("empty")
            }
            return
        }

        data.forEachIndexed { index, sampleModel ->
            val title = sampleModel.title
            val description = sampleModel.description

            itemNotify {
                id("$index")
                title(title)
                description(description)
            }
        }
    }
}
