package edu.bo.ucb.bottomnav2application

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MainPageAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    private var screens = arrayListOf<MainScreen>()
    override fun getItem(position: Int): Fragment {
        return screens.get(position).fragment
    }
    fun setItems(screens: List<MainScreen>) {
        this.screens = screens as ArrayList<MainScreen>
    }
    override fun getCount(): Int {
        return screens.size
    }
    fun getItems(): List<MainScreen> {
        return screens
    }
}