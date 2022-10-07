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
import com.example.mainactivity.classes.Caracter
import com.example.mainactivity.data.datasource.api.RetrofitInstance
import com.example.mainactivity.data.datasource.model.variouscharacters.AllAssetsForAllResponse
import com.example.mainactivity.data.datasource.util.dataStoree
import com.example.mainactivity.data.datasource.util.mail
import com.example.mainactivity.data.datasource.util.removeValue
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import com.example.mainactivity.data.datasource.local_source.CaracterDB
class CharactersFragment: Fragment(R.layout.characters_fragment), CaracterAdapter.PlaceListener {
    private lateinit var toolbar: MaterialToolbar
    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonAZ: Button
    private lateinit var buttonZA: Button
    private lateinit var apiResult : MutableList<Result>
    private lateinit var syncButton:ImageButton
    private lateinit var database: CaracterDB
    private var caracterList:MutableList<Caracter> = mutableListOf()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.RecyclerView_CharactersFragment)
        buttonAZ = view.findViewById(R.id.btn_sortAz)
        buttonZA = view.findViewById(R.id.btn_sortZA)
        toolbar = view.findViewById(R.id.toolbar_Characters1Fragment)
        syncButton = view.findViewById(R.id.synchronize_iv_characterF)
        database = Room.databaseBuilder(
            requireContext(),
            CaracterDB::class.java,
            "dbname"
        ).build()
        apiRequest()
        getCharacters()
        setUpRecycler()
        setToolbar()
        setListeners()
    }
    private fun getCharacters(){
        CoroutineScope(Dispatchers.IO).launch {
            if (database.caracterDao().getCaracters().isNullOrEmpty()){
                RetrofitInstance.api.getCharacters().enqueue(object : retrofit2.Callback<AllAssetsForAllResponse> {
                    override fun onResponse(
                        call: Call<AllAssetsForAllResponse>,
                        response: Response<AllAssetsForAllResponse>
                    ) {
                        if (response.isSuccessful && response.body() != null){
                            apiResult = response.body()!!.results as MutableList<Result>
                        }
                    }

                    override fun onFailure(call: Call<AllAssetsForAllResponse>, t: Throwable) {
                        println("Error")
                    }

                })
                for (car in apiResult){
                    val caracter = Caracter(
                        id = car.id,
                        name = car.name,
                        species = car.species,
                        status = car.status,
                        gender = car.gender,
                        image = car.image
                    )
                    database.caracterDao().insertCharacter(caracter)
                }
            }
            else{
                caracterList = database.caracterDao().getCaracters() as MutableList<Caracter>
            }
        }

    }
    private fun apiRequest(){
        RetrofitInstance.api.getCharacters().enqueue(object : retrofit2.Callback<AllAssetsForAllResponse> {
            override fun onResponse(
                call: Call<AllAssetsForAllResponse>,
                response: Response<AllAssetsForAllResponse>
            ) {
                if (response.isSuccessful && response.body() != null){
                    apiResult = response.body()!!.results as MutableList<Result>
                }
            }

            override fun onFailure(call: Call<AllAssetsForAllResponse>, t: Throwable) {
                println("Error")
            }

        })
        }

    override fun onPlaceClicked(data: Caracter, position: Int) {
        val action = CharactersFragmentDirections.actionCharactersFragment2ToCharacterDetailsFragment(data.id.toString())
        requireView().findNavController().navigate(action)
    }
    private fun setUpRecycler(){
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CaracterAdapter(caracterList, this)
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun setListeners() {
        buttonAZ.setOnClickListener {
            apiResult.sortBy { character -> character.name }
            recyclerView.adapter!!.notifyDataSetChanged()
        }
        buttonZA.setOnClickListener {
            apiResult.sortByDescending { character -> character.name }
            recyclerView.adapter!!.notifyDataSetChanged()
        }
        setToolbar()
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
                R.id.btn_sortAz->{
                    apiResult.sortBy { character -> character.name }
                    recyclerView.adapter!!.notifyDataSetChanged()
                    true
                }
                R.id.logout -> {
                    CoroutineScope(Dispatchers.IO).launch {
                        requireContext().dataStoree.removeValue(mail)
                    }
                    CoroutineScope(Dispatchers.Main).launch {
                        requireView().findNavController().navigate(CharactersFragmentDirections.actionCharactersFragment2ToLogIn())
                    }
                    true
                }
                R.id.btn_sortZA->{
                    apiResult.sortByDescending { character -> character.name }
                    recyclerView.adapter!!.notifyDataSetChanged()
                    true
                }

                else -> true
            }
        }
    }
}