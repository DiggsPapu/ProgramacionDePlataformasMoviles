package com.example.mainactivity.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.mainactivity.R

class MainActivity : AppCompatActivity() {
    private lateinit var topAppBar: Toolbar
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.charactersFragment) as NavHostFragment
        navController = navHostFragment.navController

        val appbarConfig = AppBarConfiguration(navController.graph)
        topAppBar = findViewById(R.id.toolbar_MainAct)
        topAppBar.setupWithNavController(navController, appbarConfig)
        setNavigation()
    }

    private fun setNavigation() {

        navController.addOnDestinationChangedListener{_, destinacion,_ ->
            when(destinacion.id){
                R.id.charactersFragment -> {
                    topAppBar.visibility = View.VISIBLE
                    topAppBar.menu.findItem(R.id.sortZa).isVisible = true
                    topAppBar.menu.findItem(R.id.sortAz).isVisible = true
                }

                R.id.charactersFragment -> {
                    topAppBar.menu.findItem(R.id.sortAz).isVisible = false
                    topAppBar.menu.findItem(R.id.sortZa).isVisible = false
                }
            }
        }

    }
}