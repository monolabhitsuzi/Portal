package com.github.monolabhituszi.portal.ui.timetable

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.monolabhituszi.portal.model.SampleTimetableModel

class TimetableViewModel : ViewModel() {
    val list = MutableLiveData<List<SampleTimetableModel>>(emptyList())

    fun add(item: SampleTimetableModel) {
        list.apply {
            this.value?.let {
                val list = it.toMutableList()
                list.add(item)
                this.value = list
            }
        }
    }
}
