package com.github.monolabhituszi.portal.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.monolabhituszi.portal.R
import com.github.monolabhituszi.portal.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // binding
        binding = FragmentHomeBinding.bind(view)

        // view model
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textHome.text = it
        })

        // lifecycle
        binding.lifecycleOwner = this
    }
}
