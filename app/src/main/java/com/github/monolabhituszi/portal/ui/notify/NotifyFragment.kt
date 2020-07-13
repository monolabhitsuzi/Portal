package com.github.monolabhituszi.portal.ui.notify

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.monolabhituszi.portal.R
import com.github.monolabhituszi.portal.databinding.FragmentNotifyBinding

class NotifyFragment : Fragment(R.layout.fragment_notify) {
    private lateinit var binding: FragmentNotifyBinding
    private lateinit var notifyViewModel: NotifyViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // binding
        binding = FragmentNotifyBinding.bind(view)

        // view model
        notifyViewModel = ViewModelProvider(this).get(NotifyViewModel::class.java)
        notifyViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textNotify.text = it
        })

        // lifecycle
        binding.lifecycleOwner = this
    }
}
