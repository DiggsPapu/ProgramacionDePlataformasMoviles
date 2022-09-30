package com.example.mainactivity.fragments
import com.example.mainactivity.data.datasource.model.variouscharacters.Result
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mainactivity.R
import com.example.mainactivity.adapters.CharacterAdapter
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

class CharactersFragment: Fragment(R.layout.characters_fragment), CharacterAdapter.PlaceListener {
    private lateinit var toolbar: MaterialToolbar
    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonAZ: Button
    private lateinit var buttonZA: Button
    private lateinit var apiResult : MutableList<Result>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.RecyclerView_CharactersFragment)
        buttonAZ = view.findViewById(R.id.btn_sortAz)
        buttonZA = view.findViewById(R.id.btn_sortZA)
        toolbar = view.findViewById(R.id.toolbar_Characters1Fragment)
        apiRequest()
        setListeners()
    }
    private fun apiRequest(){
        RetrofitInstance.api.getCharacters().enqueue(object : retrofit2.Callback<AllAssetsForAllResponse> {
            override fun onResponse(
                call: Call<AllAssetsForAllResponse>,
                response: Response<AllAssetsForAllResponse>
            ) {
                if (response.isSuccessful && response.body() != null){
                    apiResult = response.body()!!.results as MutableList<Result>
                    setUpRecycler()
                }
            }

            override fun onFailure(call: Call<AllAssetsForAllResponse>, t: Throwable) {
                println("Error")
            }

        })
        }

    override fun onPlaceClicked(data: Result, position: Int) {
        val action = CharactersFragmentDirections.actionCharactersFragment2ToCharacterDetailsFragment(data.id.toString())
        requireView().findNavController().navigate(action)
    }
    private fun setUpRecycler(){
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CharacterAdapter(apiResult, this)
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
                    CoroutineScope(Dispatchers.IO).launch {
                        apiResult.sortBy { character -> character.name }
                        recyclerView.adapter!!.notifyDataSetChanged()
                    }
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