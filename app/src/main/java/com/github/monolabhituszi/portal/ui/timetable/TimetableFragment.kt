package com.github.monolabhituszi.portal.ui.timetable

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.monolabhituszi.portal.R
import com.github.monolabhituszi.portal.databinding.FragmentTimetableBinding
import com.github.monolabhituszi.portal.model.SampleModel
import com.github.monolabhituszi.portal.ui.timetable.animation.ZoomOutPageTransformer

class TimetableFragment : Fragment(R.layout.fragment_timetable) {
    private lateinit var binding: FragmentTimetableBinding
    private lateinit var timetableViewModel: TimetableViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // binding
        binding = FragmentTimetableBinding.bind(view)

        // view model
        timetableViewModel = ViewModelProvider(this).get(TimetableViewModel::class.java)

        // lifecycle
        binding.lifecycleOwner = this

        val adapter = TimetableAdapter()

        val sampleItem = listOf(
            SampleModel(
                title = "月曜日",
                description = "月曜日の時間割"
            ),
            SampleModel(
                title = "火曜日",
                description = "火曜日の時間割"
            ),
            SampleModel(
                title = "水曜日",
                description = "水曜日の時間割"
            ),
            SampleModel(
                title = "木曜日",
                description = "木曜日の時間割"
            ),
            SampleModel(
                title = "金曜日",
                description = "金曜日の時間割"
            )
        )

        binding.viewpager.offscreenPageLimit = 2
        binding.viewpager.setPageTransformer(ZoomOutPageTransformer())

        binding.viewpager.apply {
            this.adapter = adapter
            adapter.setItem(sampleItem)
        }
    }
}
