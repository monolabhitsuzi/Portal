package com.github.monolabhituszi.portal.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.github.monolabhituszi.portal.R
import com.github.monolabhituszi.portal.databinding.FragmentHomeBinding
import com.github.monolabhituszi.portal.ui.home.controller.HomeController
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    companion object {
        val weekdays: Array<String> = arrayOf("他", "日", "月", "火", "水", "木", "金", "土")
    }

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var controller: HomeController

    private lateinit var adapter: HomeCollectionAdapter
    private lateinit var viewPager: ViewPager2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // binding
        binding = FragmentHomeBinding.bind(view)

        // view model
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        // lifecycle
        binding.lifecycleOwner = this

        adapter = HomeCollectionAdapter(this)
        viewPager = binding.pager
        viewPager.adapter = adapter

        val tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = weekdays[position]
        }.attach()

        val today = Calendar.getInstance()
        tabLayout.getTabAt(today.get(Calendar.DAY_OF_WEEK))?.select()
    }
}

class HomeCollectionAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 8

    override fun createFragment(position: Int): Fragment {
        // Return a NEW fragment instance in createFragment(int)
        val fragment = TimeTableItem()
        fragment.arguments = Bundle().apply {
            // Our object is just an integer :-P
            putInt(ARG_OBJECT, position + 1)
        }
        return fragment
    }
}

private const val ARG_OBJECT = "object"

class TimeTableItem : Fragment()
