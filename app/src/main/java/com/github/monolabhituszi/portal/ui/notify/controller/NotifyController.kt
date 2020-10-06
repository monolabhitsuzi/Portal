package com.github.monolabhituszi.portal.ui.notify.controller

import com.airbnb.epoxy.TypedEpoxyController
import com.github.monolabhituszi.portal.itemEmpty
import com.github.monolabhituszi.portal.itemNotify
import com.github.monolabhituszi.portal.model.SampleNotifyModel

class NotifyController : TypedEpoxyController<List<SampleNotifyModel>>() {
    override fun buildModels(data: List<SampleNotifyModel>?) {
        requireNotNull(data)
        if (data.isEmpty()) {
            itemEmpty {
                id("empty")
            }
            return
        }

        data.forEachIndexed { index, sampleNotifyModel ->
            val title = sampleNotifyModel.title
            val description = sampleNotifyModel.description
            val date= sampleNotifyModel.date

            itemNotify {
                id("$index")
                title(title)
                description(description)
                date(date)
            }
        }
    }
}
