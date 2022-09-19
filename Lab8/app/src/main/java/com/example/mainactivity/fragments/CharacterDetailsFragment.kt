package com.example.mainactivity.fragments

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import coil.request.CachePolicy
import coil.transform.CircleCropTransformation
import com.example.mainactivity.R

class CharacterDetail : Fragment(R.layout.characterdetails_fragment){

    private lateinit var characterImage : ImageView
    private lateinit var characterName : TextView
    private lateinit var characterSpecies : TextView
    private lateinit var characterStatus : TextView
    private lateinit var characterGender : TextView

    private val args:CharacterDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        characterImage = view.findViewById(R.id.imageView_characterDetail_fragment)
        characterName = view.findViewById(R.id.nameCharacter_characterDetail_fragment)
        characterSpecies = view.findViewById(R.id.textRace_characterDetail_fragment)
        characterStatus = view.findViewById(R.id.textAliveDeath_characterDetail_fragment)
        characterGender = view.findViewById(R.id.textMaleFemale_characterDetail_fragment)

        setImage()
        setInfo()
    }

    private fun setImage() {
        characterImage.load(args.characterType.image) {
            transformations(CircleCropTransformation())
            diskCachePolicy(CachePolicy.ENABLED)
            memoryCachePolicy(CachePolicy.ENABLED)
            error(R.drawable.ic_baseline_error_24)
            placeholder(R.drawable.ic_baseline_replay_24)
        }
    }

    private fun setInfo() {
        characterName.text = args.characterType.name
        characterSpecies.text = args.characterType.species
        characterStatus.text = args.characterType.status
        characterGender.text = args.characterType.gender
    }
}