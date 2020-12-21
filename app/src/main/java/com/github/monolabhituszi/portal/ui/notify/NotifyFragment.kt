package com.github.monolabhituszi.portal.ui.notify

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.monolabhituszi.portal.NotifyActivity
import com.github.monolabhituszi.portal.R
import com.github.monolabhituszi.portal.databinding.FragmentNotifyBinding
import com.github.monolabhituszi.portal.model.SampleNotifyModel
import com.github.monolabhituszi.portal.ui.notify.controller.NotifyController

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

        controller = NotifyController(
            object : NotifyController.Listener{
                override fun onClickItem(index: Int) {
                    val intent = Intent(context, NotifyActivity::class.java)
                    startActivity(intent)
                    binding.recyclerView[index].setBackgroundColor(Color.LTGRAY)
                }
            }
        )

        binding.recyclerView.also {
            it.setController(controller)
        }

        val sampleData = listOf<SampleNotifyModel>(
            SampleNotifyModel(
                title = "通知1",
                description = "通知1だよー",
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
