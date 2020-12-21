package com.github.monolabhituszi.portal.ui.timetable.controller

import com.airbnb.epoxy.TypedEpoxyController
import com.github.monolabhituszi.portal.itemEmpty
import com.github.monolabhituszi.portal.itemTimetable
import com.github.monolabhituszi.portal.model.SampleTimetableModel
import java.util.*

class TimetableController(
    private val listener: Listener
) : TypedEpoxyController<List<SampleTimetableModel>>() {
    override fun buildModels(data: List<SampleTimetableModel>?) {
        requireNotNull(data)
        if (data.isEmpty()) {
            itemEmpty {
                id("empty")
            }
        }

        data.forEachIndexed { index, sampleModel ->
            val title = sampleModel.title
            val description = sampleModel.description
            val time = sampleModel.time
            val location = sampleModel.location

            itemTimetable {
                id(index)
                title(title)
                description(description)
                time(time + "限目")
                location(location)
                listener { _ -> listener.onClickItem(index) }
            }
        }
    }

    interface Listener {
        fun onClickItem(index: Int)
    }
}
