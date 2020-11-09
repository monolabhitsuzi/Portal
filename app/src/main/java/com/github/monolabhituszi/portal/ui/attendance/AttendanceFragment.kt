package com.github.monolabhituszi.portal.ui.attendance

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.monolabhituszi.portal.R
import com.github.monolabhituszi.portal.databinding.FragmentAttendanceBinding
import com.github.monolabhituszi.portal.ui.attendance.controller.AttendanceController

class AttendanceFragment : Fragment(R.layout.fragment_attendance) {
    private lateinit var binding: FragmentAttendanceBinding
    private lateinit var attendanceViewModel: AttendanceViewModel
    private lateinit var controller: AttendanceController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // binding
        binding = FragmentAttendanceBinding.bind(view)

        // view model
        attendanceViewModel = ViewModelProvider(this).get(AttendanceViewModel::class.java)

        // lifecycle
        binding.lifecycleOwner = this
    }
}
