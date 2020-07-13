package com.github.monolabhituszi.portal.ui.timetable

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimetableViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is timetable Fragment"
    }
    val text: LiveData<String> = _text
}
