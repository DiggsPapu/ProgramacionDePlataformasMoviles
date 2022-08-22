package com.example.mainactivity

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer

class MainActivity : AppCompatActivity() {
    private lateinit var imageButtonHome:ImageButton
    private lateinit var imageButtonSearch:ImageButton
    private lateinit var imageButtonLibrary:ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var searchFragment = SearchFragment()
        var yourLibraryFragment = YourLibraryFragment()
        var fragmentHome = fragment_Home()
        imageButtonHome =findViewById(R.id.btn_ActivityMain_Home)
        imageButtonSearch =findViewById(R.id.btn_ActivityMain_Search)
        imageButtonLibrary =findViewById(R.id.btn_ActivityMain_Library)
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.fragmentContainer_mainActivity_SpotifySelector, fragmentHome)
            addToBackStack(null)
            commit()
        }
        imageButtonHome.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer_mainActivity_SpotifySelector, fragmentHome)
                addToBackStack(null)
                commit()
            }
        }
        imageButtonSearch.setOnClickListener{
            supportFragmentManager.beginTransaction().apply{
                replace(R.id.fragmentContainer_mainActivity_SpotifySelector, searchFragment)
                addToBackStack(null)
                commit()

            }
        }
        imageButtonLibrary.setOnClickListener{
            supportFragmentManager.beginTransaction().apply{
                replace(R.id.fragmentContainer_mainActivity_SpotifySelector, yourLibraryFragment)
                commit()

            }
        }

    }

}