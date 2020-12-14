package com.github.monolabhituszi.portal.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.github.monolabhituszi.portal.ui.timetable.TimetableFragment

private const val ARG_OBJECT = "object"

class HomeCollectionAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 8

    override fun createFragment(position: Int): Fragment {
        val fragment = TimetableFragment()
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT, position + 1)
        }
        return fragment
    }
}
