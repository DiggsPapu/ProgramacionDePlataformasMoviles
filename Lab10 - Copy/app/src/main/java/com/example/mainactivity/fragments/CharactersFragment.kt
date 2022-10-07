package com.example.mainactivity.fragments
import com.example.mainactivity.data.datasource.model.variouscharacters.Result
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.mainactivity.R
import com.example.mainactivity.adapters.CaracterAdapter
import com.example.mainactivity.adapters.CharacterAdapter
import com.example.mainactivity.classes.Caracter
import com.example.mainactivity.data.datasource.api.RetrofitInstance
import com.example.mainactivity.data.datasource.local_source.CaracterDB
import com.example.mainactivity.data.datasource.model.variouscharacters.AllAssetsForAllResponse
import com.example.mainactivity.data.datasource.util.dataStoree
import com.example.mainactivity.data.datasource.util.mail
import com.example.mainactivity.data.datasource.util.removeValue
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharactersFragment: Fragment(R.layout.characters_fragment), CaracterAdapter.ListenerPlace {
    private lateinit var toolbar: MaterialToolbar
    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonAZ: Button
    private lateinit var buttonZA: Button
    private lateinit var apiResult : MutableList<Result>
    private var characters: MutableList<Caracter> = mutableListOf()
    private lateinit var database: CaracterDB
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.RecyclerView_CharactersFragment)
        buttonAZ = view.findViewById(R.id.btn_sortAz)
        buttonZA = view.findViewById(R.id.btn_sortZA)
        toolbar = view.findViewById(R.id.toolbar_Characters1Fragment)
        database = Room.databaseBuilder(
            requireContext(),
            CaracterDB::class.java,
            "dbname"
        ).build()

        initListeners()
        setListeners()
        getCharacters()
        setUpRecycler()
    }
    private fun getCharacters(){
        CoroutineScope(Dispatchers.IO).launch {
            characters.addAll(database.caracterDao().getCaracters())
        }
        CoroutineScope(Dispatchers.Main).launch {
            if (database.caracterDao().getCaracters().size==0){
                apiRequest()
            }
            else{
                recyclerView.adapter!!.notifyDataSetChanged()
            }
        }
    }
    private fun apiRequest(){
        RetrofitInstance.api.getCharacters().enqueue(object : Callback<AllAssetsForAllResponse> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(
                call: Call<AllAssetsForAllResponse>,
                response: Response<AllAssetsForAllResponse>
            ) {
                if (response.isSuccessful && response.body() != null){
                    for (character in response.body()!!.results){
                        val caracter = Caracter(
                            name = character.name,
                            id = character.id,
                            status = character.status,
                            species = character.species,
                            image = character.image,
                            gender = character.gender
                        )
                        CoroutineScope(Dispatchers.IO).launch {
                            database.caracterDao().insertCharacter(caracter)
                        }
                        characters.add(caracter)
                    }
                    CoroutineScope(Dispatchers.Main).launch{
                        recyclerView.adapter!!.notifyDataSetChanged()
                    }

//                    apiResult = response.body()!!.results as MutableList<Result>

                }
            }

            override fun onFailure(call: Call<AllAssetsForAllResponse>, t: Throwable) {
                println("Error")
            }

        })
        }

//    override fun onPlaceClicked(data: Result, position: Int) {
//        val action = CharactersFragmentDirections.actionCharactersFragment2ToCharacterDetailsFragment(data.id.toString())
//        requireView().findNavController().navigate(action)
//    }
    private fun setUpRecycler(){
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CaracterAdapter(characters, this)
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun setListeners() {
        buttonAZ.setOnClickListener {
            characters.sortBy { character -> character.name }
            recyclerView.adapter!!.notifyDataSetChanged()
        }
        buttonZA.setOnClickListener {
            characters.sortByDescending { character -> character.name }
            recyclerView.adapter!!.notifyDataSetChanged()
        }
    }
    private fun setToolbar() {
        val navController = findNavController()
        val appbarConfig = AppBarConfiguration(navController.graph)
        toolbar.setupWithNavController(navController, appbarConfig)
        initListeners()
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun initListeners() {
        toolbar.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId) {
                R.id.btn_sortAz->{
                    characters.sortBy { character -> character.name }
                    recyclerView.adapter!!.notifyDataSetChanged()
                    true
                }
                R.id.logout -> {
                    CoroutineScope(Dispatchers.IO).launch {
                        requireContext().dataStoree.removeValue(mail)
                        database.caracterDao().deleteAll()
                    }
                    CoroutineScope(Dispatchers.Main).launch {
                        requireView().findNavController().navigate(CharactersFragmentDirections.actionCharactersFragment2ToLogIn())
                    }
                    true
                }
                R.id.sync_iv_charactersF->{
                    characters.clear()
                    CoroutineScope(Dispatchers.IO).launch{
                        database.caracterDao().deleteAll()
                    }
                    apiRequest()
                    true
                }
                R.id.btn_sortZA->{
                    characters.sortByDescending { character -> character.name }
                    recyclerView.adapter!!.notifyDataSetChanged()
                    true
                }

                else -> true
            }
        }
    }

    override fun clickedOnPlace(result: Caracter, position: Int) {
        val action = CharactersFragmentDirections.actionCharactersFragment2ToCharacterDetailsFragment(result.id.toString())
        requireView().findNavController().navigate(action)
    }
}