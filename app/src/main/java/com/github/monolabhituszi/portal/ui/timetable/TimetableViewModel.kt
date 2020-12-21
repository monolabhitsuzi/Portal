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

    fun clear() {
        list.apply {
            this.value?.let {
                val list = it.toMutableList()
                list.clear()
                this.value = list
            }
        }
    }

    fun contains(item: SampleTimetableModel): Boolean {
        list.apply {
            this.value?.let {
                val list = it.toMutableList()
                return list.contains(item)
            }
            return false
        }
    }
}
