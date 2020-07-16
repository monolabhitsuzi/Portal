package com.github.monolabhituszi.portal.ui.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.monolabhituszi.portal.R
import com.github.monolabhituszi.portal.databinding.FragmentSettingsBinding

class SettingsFragment: Fragment(R.layout.fragment_settings) {

    private lateinit var binding: FragmentSettingsBinding
    private lateinit var settingViewModel: SettingsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSettingsBinding.bind(view)

        settingViewModel = ViewModelProvider(this).get(SettingsViewModel::class.java)
        settingViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textSetting.text = it
        })

        binding.lifecycleOwner = this
    }

}