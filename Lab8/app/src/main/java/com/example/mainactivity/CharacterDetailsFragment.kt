package com.example.mainactivity

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import coil.request.CachePolicy
import coil.transform.CircleCropTransformation

class CharacterDetailsFragment: Fragment(R.layout.characterdetails_fragment) {
    private lateinit var imageView: ImageView
    private lateinit var name: TextView
    private lateinit var species: TextView
    private lateinit var status: TextView
    private lateinit var gender: TextView
    private val args:CharacterDetailsFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView = view.findViewById(R.id.iv_fragmentDetail)
        name = view.findViewById(R.id.nametxtv_detailsFragment)
        species = view.findViewById(R.id.speciestxtv_detailsFragment)
        status = view.findViewById(R.id.statustxtv_detailsFragment)
        gender = view.findViewById(R.id.gendertxtv_detailsFragment)
        setAll()
    }
    private fun setAll(){
        imageView.load(args.character.image){
            transformations(CircleCropTransformation())
            diskCachePolicy(CachePolicy.ENABLED)
            memoryCachePolicy(CachePolicy.ENABLED)
            error(R.drawable.ic_baseline_error_24)
            placeholder(R.drawable.ic_baseline_replay_24)
        }
        name.text = args.character.name
        species.text = "Specie: "+args.character.species
        status.text = "Status: "+ args.character.status
        gender.text = "Gender: "+args.character.gender
    }
}