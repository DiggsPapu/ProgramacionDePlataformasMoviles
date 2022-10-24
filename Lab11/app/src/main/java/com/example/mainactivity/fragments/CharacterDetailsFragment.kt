package com.example.mainactivity.fragments

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
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
import com.example.mainactivity.classes.Caracter
import com.example.mainactivity.classes.Character
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
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class CharacterDetailsFragment: Fragment(R.layout.characterdetails_fragment) {
    private lateinit var  toolbar: MaterialToolbar
    private lateinit var imageView: ImageView
    private lateinit var name: TextInputLayout
    private lateinit var species: TextInputLayout
    private lateinit var status: TextInputLayout
    private lateinit var gender: TextInputLayout
    private lateinit var origin: TextInputLayout
    private lateinit var apperances: TextInputLayout
    private lateinit var result:AllAssetsForOneCharacterResponse
    private lateinit var database:CaracterDB
    private lateinit var character: Caracter
    private lateinit var save: Button
    private val args: CharacterDetailsFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        save = view.findViewById(R.id.save_btn_detailsFragment)
        toolbar = view.findViewById(R.id.toolbar_CharactersFragment)
        imageView = view.findViewById(R.id.iv_fragmentDetail)
        name = view.findViewById(R.id.inputLayout_characterDetails_name)
        species = view.findViewById(R.id.inputLayout_characterDetails_species)
        status = view.findViewById(R.id.inputLayout_characterDetails_status)
        gender = view.findViewById(R.id.inputLayout_characterDetails_gender)
        apperances = view.findViewById(R.id.inputLayout_characterDetails_episodes)
        database = Room.databaseBuilder(
            requireContext(),
            CaracterDB::class.java,
            "dbname"
        ).build()
        setToolbar()
        initListeners()
        getCharacter()

    }
    private fun getCharacter() {
        lifecycleScope.launchWhenStarted {
            val localCharacter = database.caracterDao().getCaracter(args.characterID.toInt())
            if (localCharacter == null) {
                Toast.makeText(requireContext(), getString(R.string.error_character_not_found), Toast.LENGTH_LONG).show()
                requireActivity().onBackPressed()
            } else {
                character = localCharacter
                setCharacter()
            }
        }
    }

    private fun setCharacter(){

        character.apply {

        }
        imageRequest()
        name.editText!!.setText(character.name)
        species.editText!!.setText(character.species)
        status.editText!!.setText(character.status)
        gender.editText!!.setText(character.gender)
        apperances.editText!!.setText(character.episodes.toString())
        imageView.load(character.image){
            transformations(CircleCropTransformation())
            diskCachePolicy(CachePolicy.ENABLED)
            memoryCachePolicy(CachePolicy.ENABLED)
            error(R.drawable.ic_baseline_error_24)
            placeholder(R.drawable.ic_baseline_replay_24)
        }
    }
    private fun setAll(){
        imageView.load(result.image){
            transformations(CircleCropTransformation())
            diskCachePolicy(CachePolicy.ENABLED)
            memoryCachePolicy(CachePolicy.ENABLED)
            error(R.drawable.ic_baseline_error_24)
            placeholder(R.drawable.ic_baseline_replay_24)
        }
        name.editText!!.setText(result.name)
        species.editText!!.setText(result.species)
        status.editText!!.setText(result.status)
        gender.editText!!.setText(result.gender)
        apperances.editText!!.setText(result.episode.size.toString())
    }
    private fun apiRequest(){
        RetrofitInstance.api.getCharacter(args.characterID).enqueue(object : retrofit2.Callback<AllAssetsForOneCharacterResponse>
        {
            override fun onResponse(
                call: Call<AllAssetsForOneCharacterResponse>,
                response: Response<AllAssetsForOneCharacterResponse>
            ) {
                if (response.isSuccessful && response.body() != null){
                    result = response.body()!!
                    setAll()
                }else {
                    Toast.makeText(requireContext(), getString(R.string.error_character_not_found), Toast.LENGTH_LONG).show()
                    requireActivity().onBackPressed()
                }
            }
            override fun onFailure(call: Call<AllAssetsForOneCharacterResponse>, t: Throwable) {
                Toast.makeText(requireContext(), getString(R.string.error_character_not_found), Toast.LENGTH_LONG).show()
            }

        }
        )
    }
    private fun imageRequest(){
        RetrofitInstance.api.getCharacter(args.characterID).enqueue(object : retrofit2.Callback<AllAssetsForOneCharacterResponse>
        {
            override fun onResponse(
                call: Call<AllAssetsForOneCharacterResponse>,
                response: Response<AllAssetsForOneCharacterResponse>
            ) {
                if (response.isSuccessful && response.body() != null){
                    result = response.body()!!
                }else {
                    Toast.makeText(requireContext(), getString(R.string.error_character_not_found), Toast.LENGTH_LONG).show()
                    requireActivity().onBackPressed()
                }
            }
            override fun onFailure(call: Call<AllAssetsForOneCharacterResponse>, t: Throwable) {
                Toast.makeText(requireContext(), getString(R.string.error_character_not_found), Toast.LENGTH_LONG).show()
            }

        }
        )
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
                R.id.sync ->{
                    apiRequest()
                    true
                }
                R.id.remove->{
                    deleteCharacter()
                    true
                }
                else->false
                }
        }
        save.setOnClickListener{
            updateCharacter()
        }

    }
    private fun updateCharacter(){
        lifecycleScope.launch {
            database.caracterDao().updateCharacter(
                character.copy(
                    name = name.editText!!.text.toString(),
                    species = species.editText!!.text.toString(),
                    status = status.editText!!.text.toString(),
                    gender = gender.editText!!.text.toString(),
                    episodes = apperances.editText!!.text.toString().toInt()
                )
            )
            Toast.makeText(requireContext(), getString(R.string.successful_update), Toast.LENGTH_LONG).show()
        }
//        CoroutineScope(Dispatchers.IO).launch {
//            val newCharacter = Caracter (
//                episodes = apperances.text as Int,
//                name = name.text as String,
//                gender = gender.text as String,
//                image = result.image,
//                id = character.id,
//                species = species.text as String,
//                status = status.text as String
//            )
//            database.caracterDao().updateCharacter(newCharacter)
//        }
    }
    private fun deleteCharacter() {
        lifecycleScope.launch {
            if (database.caracterDao().deleteCharacter(character) > 0) {
                Toast.makeText(requireContext(), getString(R.string.successful_delete), Toast.LENGTH_LONG).show()
                requireActivity().onBackPressed()
            } else {
                Toast.makeText(requireContext(), "Error, try again to erase the character.", Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun setToolbar() {
        val navController = findNavController()
        val appbarConfig = AppBarConfiguration(navController.graph)
        toolbar.setupWithNavController(navController, appbarConfig)

    }
}