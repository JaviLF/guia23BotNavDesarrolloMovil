package edu.bo.ucb.bottomnav2application

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

enum class MainScreen(@IdRes val menuItemId: Int,
                      @DrawableRes val menuItemIconId: Int,
                      @StringRes val titleStringId: Int,
                      val fragment: Fragment
) {
    HOME(R.id.home_bottom_navigation_menu, R.drawable.ic_launcher_background,
        R.string.home_bottom_navigation_menu, HomeFragment()),
    PROFILE(R.id.profile_bottom_navigation_menu, R.drawable.ic_launcher_foreground,
        R.string.profile_bottom_navigation_menu, ProfileFragment())
}
fun getMainScreenForMenuItem(menuItemId: Int): MainScreen? {
    for(mainScreen in MainScreen.values()) {
        if( mainScreen.menuItemId == menuItemId) {
            return mainScreen
        }
    }
    return null
}