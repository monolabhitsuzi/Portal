package com.github.monolabhituszi.portal.ui.timetable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.monolabhituszi.portal.R
import com.github.monolabhituszi.portal.databinding.FragmentTimetableBinding

class TimetableFragment : Fragment(R.layout.fragment_timetable) {
    private lateinit var binding: FragmentTimetableBinding
    private lateinit var timetableViewModel: TimetableViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTimetableBinding.inflate(inflater, container, false)

        timetableViewModel = ViewModelProvider(this).get(TimetableViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_timetable, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        timetableViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
