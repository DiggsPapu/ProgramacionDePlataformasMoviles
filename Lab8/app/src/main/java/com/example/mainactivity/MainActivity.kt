package com.example.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: MaterialToolbar
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.FragmentContainer_MainAct) as NavHostFragment
        navController = navHostFragment.navController
        val appbarconfig = AppBarConfiguration(navController.graph)
        toolbar = findViewById(R.id.toolbar_MainAct)
        toolbar.setupWithNavController(navController, appbarconfig)
        listenToNavGraphChanges()
    }

    private fun listenToNavGraphChanges(){
        navController.addOnDestinationChangedListener(NavController.OnDestinationChangedListener{_, destination,_->
            when(destination.id){
                R.id.charactersFragment->{
                    toolbar.visibility = View.VISIBLE
                }
                else -> {
                    toolbar.menu.clear()
                }
            }
        }
        )
    }
}