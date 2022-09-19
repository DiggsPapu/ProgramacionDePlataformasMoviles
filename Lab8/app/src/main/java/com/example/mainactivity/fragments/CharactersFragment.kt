package com.example.mainactivity.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mainactivity.R
import com.example.mainactivity.Adapter.CharacterAdapter
import com.example.mainactivity.database.Character
import com.example.mainactivity.database.RickAndMortyDB
class PlaceListFragment : Fragment(R.layout.characters_fragment), CharacterAdapter.CharactersF {

    private lateinit var recyclerView: RecyclerView
    private lateinit var placesList: MutableList<Character>
    private lateinit var buttonAZ: Button
    private lateinit var buttonZA: Button



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.RecyclerView_CharactersFragment)
        buttonAZ = view.findViewById(R.id.sortAz)
        buttonZA = view.findViewById(R.id.sortZa)

        setupRecycler()
        setListeners()
    }


    private fun setListeners() {
        buttonAZ.setOnClickListener{
            placesList.sortBy { place -> place.name }
            recyclerView.adapter!!.notifyDataSetChanged()
        }

        buttonZA.setOnClickListener{
            placesList.sortByDescending { place -> place.name }
            recyclerView.adapter!!.notifyDataSetChanged()
        }
    }

    private fun setupRecycler() {
        placesList = RickAndMortyDB.getCharacters()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CharacterAdapter(placesList, this)
    }

    override fun onCharacterClicked(data: Character, position: Int) {
        requireView().findNavController().navigate(
            CharactersFragmentDirections.actionCharactersFragment2ToCharacterDetailsFragment(
                data
            )
        )
    }
}