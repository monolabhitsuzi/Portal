package com.github.monolabhituszi.portal.ui.timetable

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.monolabhituszi.portal.R
import com.github.monolabhituszi.portal.databinding.FragmentTimetableBinding
import com.github.monolabhituszi.portal.model.SampleTimetableModel
import com.github.monolabhituszi.portal.ui.timetable.controller.TimetableController

class TimetableFragment : Fragment(R.layout.fragment_timetable) {
    private lateinit var binding: FragmentTimetableBinding
    private lateinit var timetableViewModel: TimetableViewModel
    private lateinit var controller: TimetableController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // binding
        binding = FragmentTimetableBinding.bind(view)

        // view model
        timetableViewModel = ViewModelProvider(this).get(TimetableViewModel::class.java)

        // lifecycle
        binding.lifecycleOwner = this

        // controller
        controller = TimetableController(
            object : TimetableController.Listener {
                override fun onClickItem(index: Int) {
                    println("Clicked!")
                }
            }
        )

        val provider = ViewModelProvider(this).get(TimetableViewModel::class.java)
        val models = listOf(
            SampleTimetableModel(
                title = "AAA",
                description = "AAAする授業です",
                weekday = 1,
                time = "4",
                location = "A教室"
            ),
            SampleTimetableModel(
                title = "AAA",
                description = "AAAする授業です",
                weekday = 2,
                time = "3",
                location = "A教室"
            ),
            SampleTimetableModel(
                title = "AAA",
                description = "AAAする授業です",
                weekday = 3,
                time = "1",
                location = "A教室"
            ),
            SampleTimetableModel(
                title = "BBB",
                description = "BBBする授業です",
                weekday = 6,
                time = "2",
                location = "B教室"
            )
        )

        provider.clear()
        models.filter { model ->
            model.weekday == arguments?.get("object")
        }.filter { model ->
            !provider.contains(model)
        }.forEach { model ->
            provider.add(model)
        }

        binding.recyclerView.also {
            it.setController(controller)
        }

        timetableViewModel.list.observe(viewLifecycleOwner, Observer(controller::setData))
    }
}
