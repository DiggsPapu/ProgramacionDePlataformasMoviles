package com.example.mainactivity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CharactersFragment: Fragment(R.layout.characters_fragment), CharacterAdapter.PlaceListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var list: MutableList<Character>
    private lateinit var buttonAZ: Button
    private lateinit var buttonZA: Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.RecyclerView_CharactersFragment)
        buttonAZ = view.findViewById(R.id.btn_sortAz)
        buttonZA = view.findViewById(R.id.btn_sortZA)
        setUpRecycler()
        setListeners()
    }
    private fun setUpRecycler(){
        list = RickAndMortyDB.getCharacters()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CharacterAdapter(list, this)
    }
    @SuppressLint("NotifyDataSetChanged")
    private fun setListeners() {
        buttonAZ.setOnClickListener {
            list.sortBy { character -> character.name }
            recyclerView.adapter!!.notifyDataSetChanged()
        }
        buttonZA.setOnClickListener {
            list.sortByDescending { character -> character.name }
            recyclerView.adapter!!.notifyDataSetChanged()
        }
    }

    override fun onPlaceClicked(data: Character, position: Int) {
        val action = CharactersFragmentDirections.actionCharactersFragment2ToCharacterDetailsFragment(data)
        requireView().findNavController().navigate(action)
    }


}