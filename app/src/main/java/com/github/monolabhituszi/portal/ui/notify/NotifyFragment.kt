package com.github.monolabhituszi.portal.ui.notify

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.monolabhituszi.portal.R
import com.github.monolabhituszi.portal.databinding.FragmentNotifyBinding
import com.github.monolabhituszi.portal.model.SampleNotifyModel
import com.github.monolabhituszi.portal.ui.notify.controller.NotifyController
import kotlinx.android.synthetic.main.fragment_notify.*

class NotifyFragment : Fragment(R.layout.fragment_notify) {
    private lateinit var binding: FragmentNotifyBinding
    private lateinit var notifyViewModel: NotifyViewModel
    private lateinit var controller: NotifyController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // binding
        binding = FragmentNotifyBinding.bind(view)

        // view model
        notifyViewModel = ViewModelProvider(this).get(NotifyViewModel::class.java)

        // lifecycle
        binding.lifecycleOwner = this

        controller = NotifyController()

        recycler_view.also {
            it.setController(controller)
        }

        val sampleData = listOf<SampleNotifyModel>(
            SampleNotifyModel(
                title = "通知１",
                description = "通知１だよー",
                date = "2020/04/01"
            ),
            SampleNotifyModel(
                title = "通知2",
                description = "通知2だよー",
                date = "2020/04/02"
            )
        )

        controller.setData(sampleData)
    }
}
