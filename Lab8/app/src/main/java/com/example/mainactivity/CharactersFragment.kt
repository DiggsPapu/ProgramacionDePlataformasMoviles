package com.example.mainactivity

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CharactersFragment: Fragment(R.layout.characters_fragment) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var list: MutableList<Character>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.RecyclerView_CharactersFragment)

        setUpRecycler()
    }
    private fun setUpRecycler(){
        list = RickAndMortyDB.getCharacters()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CharacterAdapter(list)
    }
}