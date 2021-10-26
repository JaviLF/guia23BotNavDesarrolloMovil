package edu.bo.ucb.bottomnav2application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.IdRes
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener {
    lateinit var mainPageAdapter: MainPageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//Initialize components/views
        val toolbar2 = findViewById(R.id.toolbar2) as Toolbar
        val main_view_pager= findViewById(R.id.main_view_pager) as ViewPager
        val bottomNavigationView = findViewById(R.id.bottomNavigationView) as BottomNavigationView

        mainPageAdapter = MainPageAdapter(supportFragmentManager)
        setSupportActionBar(toolbar2)
        mainPageAdapter.setItems(arrayListOf( MainScreen.PROFILE,
            MainScreen.HOME))
        main_view_pager.adapter = mainPageAdapter
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
        main_view_pager.addOnPageChangeListener( object:
            ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                val selectedScreen = mainPageAdapter.getItems()[position]
                selectBottomNavigationViewMenuItem(selectedScreen.menuItemId)
                supportActionBar?.setTitle(selectedScreen.titleStringId)
            }
        })
    }


    private fun selectBottomNavigationViewMenuItem(@IdRes menuItemId: Int) {
        val bottomNavigationView = findViewById(R.id.bottomNavigationView) as BottomNavigationView

        bottomNavigationView.setOnNavigationItemReselectedListener(null)
        bottomNavigationView.selectedItemId = menuItemId
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        getMainScreenForMenuItem(item.itemId)?.let {
            scrollToScreen(it)
            supportActionBar?.setTitle(it.titleStringId)
            return true
        }
        return false
    }

    private fun scrollToScreen(it: MainScreen) {
        val main_view_pager= findViewById(R.id.main_view_pager) as ViewPager
        val screenPosition = mainPageAdapter.getItems().indexOf(it)
        if(screenPosition != main_view_pager.currentItem) {
            main_view_pager.currentItem = screenPosition
        }
    }
}