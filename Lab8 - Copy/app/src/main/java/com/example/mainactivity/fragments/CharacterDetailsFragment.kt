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
import com.example.mainactivity.data.datasource.api.RetrofitInstance
import com.example.mainactivity.data.datasource.model.onecharacter.AllAssetsForOneCharacterResponse
import com.example.mainactivity.data.datasource.model.variouscharacters.AllAssetsForAllResponse
import com.example.mainactivity.data.datasource.model.variouscharacters.Result
import retrofit2.Call
import retrofit2.Response

class CharacterDetailsFragment: Fragment(R.layout.characterdetails_fragment) {
    private lateinit var imageView: ImageView
    private lateinit var name: TextView
    private lateinit var species: TextView
    private lateinit var status: TextView
    private lateinit var gender: TextView
    private lateinit var result:AllAssetsForOneCharacterResponse
    private val args: CharacterDetailsFragmentArgs by navArgs()
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
        imageView.load(result.image){
            transformations(CircleCropTransformation())
            diskCachePolicy(CachePolicy.ENABLED)
            memoryCachePolicy(CachePolicy.ENABLED)
            error(R.drawable.ic_baseline_error_24)
            placeholder(R.drawable.ic_baseline_replay_24)
        }
        name.text = result.name
        species.text = "Specie: "+result.species
        status.text = "Status: "+ result.status
        gender.text = "Gender: "+result.gender
    }
    private fun apiRequest(){
        RetrofitInstance.api.getCharacter(args.characterID).enqueue(object : retrofit2.Callback<AllAssetsForOneCharacterResponse> {
            override fun onResponse(
                call: Call<AllAssetsForOneCharacterResponse>,
                response: Response<AllAssetsForOneCharacterResponse>
            ) {
                if (response.isSuccessful && response.body() != null){
                    result = response.body()!!
                    setAll()
                }
            }
            override fun onFailure(call: Call<AllAssetsForOneCharacterResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}