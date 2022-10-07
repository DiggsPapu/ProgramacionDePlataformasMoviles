package com.example.mainactivity.fragments

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import coil.load
import coil.request.CachePolicy
import coil.transform.CircleCropTransformation
import com.example.mainactivity.R
import com.example.mainactivity.data.datasource.api.RetrofitInstance
import com.example.mainactivity.data.datasource.local_source.CaracterDB
import com.example.mainactivity.data.datasource.model.onecharacter.AllAssetsForOneCharacterResponse
import com.example.mainactivity.data.datasource.model.variouscharacters.AllAssetsForAllResponse
import com.example.mainactivity.data.datasource.model.variouscharacters.Result
import com.example.mainactivity.data.datasource.util.dataStoree
import com.example.mainactivity.data.datasource.util.mail
import com.example.mainactivity.data.datasource.util.removeValue
import com.example.mainactivity.data.datasource.util.saveValue
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class CharacterDetailsFragment: Fragment(R.layout.characterdetails_fragment) {
    private lateinit var  toolbar: MaterialToolbar
    private lateinit var imageView: ImageView
    private lateinit var name: TextView
    private lateinit var species: TextView
    private lateinit var status: TextView
    private lateinit var gender: TextView
    private lateinit var origin: TextView
    private lateinit var apperances: TextView
    private lateinit var result:AllAssetsForOneCharacterResponse
    private lateinit var database:CaracterDB
    private val args: CharacterDetailsFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar = view.findViewById(R.id.toolbar_CharactersFragment)
        imageView = view.findViewById(R.id.iv_fragmentDetail)
        name = view.findViewById(R.id.nametxtv_detailsFragment)
        species = view.findViewById(R.id.speciestxtv_detailsFragment)
        status = view.findViewById(R.id.statustxtv_detailsFragment)
        gender = view.findViewById(R.id.gendertxtv_detailsFragment)
        origin = view.findViewById(R.id.origintxtv_detailsFragment)
        apperances = view.findViewById(R.id.episodeapptxtv_detailsFragment)
        database = Room.databaseBuilder(
            requireContext(),
            CaracterDB::class.java,
            "dbname"
        ).build()
        setToolbar()
        apiRequest()

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
        origin.text = "Origin: "+result.origin.name
        apperances.text = "Episode Apperances: "+result.episode.size.toString()
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

        }
        )
    }
    private fun setToolbar() {
        val navController = findNavController()
        val appbarConfig = AppBarConfiguration(navController.graph)
        toolbar.setupWithNavController(navController, appbarConfig)
        initListeners()
    }
    private fun initListeners() {
        toolbar.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId) {
                R.id.logout -> {
                    CoroutineScope(Dispatchers.IO).launch {
                        requireContext().dataStoree.removeValue(mail)
                    }
                    CoroutineScope(Dispatchers.Main).launch {
                        requireView().findNavController().navigate(CharacterDetailsFragmentDirections.actionCharacterDetailsFragmentToLogIn())
                    }
                    true
                }

                else -> true
            }
        }
    }
}

