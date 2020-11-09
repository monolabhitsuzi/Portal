package com.github.monolabhituszi.portal.ui.task

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.monolabhituszi.portal.model.SampleTaskModel

class TaskViewModel : ViewModel() {
    val list = MutableLiveData<List<SampleTaskModel>>(emptyList())

    fun add(item: SampleTaskModel) {
        list.apply {
            this.value?.let {
                val list = it.toMutableList()
                list.add(item)
                this.value = list
            }
        }
    }
}
