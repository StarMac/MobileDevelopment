package com.example.homeproject2.ui.ui.tabbed

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SectionsPager2Adapter(fragment : FragmentActivity) : FragmentStateAdapter(fragment)
{

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return PlaceholderFragment.newInstance(position + 1)
    }
}