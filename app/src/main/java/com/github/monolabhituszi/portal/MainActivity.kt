package com.github.monolabhituszi.portal

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.github.monolabhituszi.portal.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val navController =
            (supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
                    as NavHostFragment).navController
        setupWithNavController(nav_view, navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_bar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController =
            (supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
                    as NavHostFragment).navController
        when(item.itemId){
            R.id.action_bar_settings -> navController.navigate(R.id.navigation_settings)
        }
        return true
    }

}
