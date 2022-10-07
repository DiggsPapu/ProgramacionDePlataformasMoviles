package com.example.mainactivity.adapters

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.example.mainactivity.classes.Caracter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import coil.load
import coil.request.CachePolicy
import coil.transform.CircleCropTransformation
import com.example.mainactivity.R

class CaracterAdapter(

    private val personajes: MutableList<Caracter>,
    private val listener : ListenerPlace
):RecyclerView.Adapter<CaracterAdapter.ViewHolder>(){
    interface ListenerPlace{
        fun clickedOnPlace(result:Caracter, position: Int)
    }
    class ViewHolder(
        private val view:View,
        private val listenerPlace:ListenerPlace
    ):
            RecyclerView.ViewHolder(view){
                private val image = view.findViewById<ImageView>(R.id.ivchar_charactersFragment)
                private val name = view.findViewById<TextView>(R.id.name_char_charactersFragment)
                private val characteristics = view.findViewById<TextView>(R.id.characteristics_char_charactersFragment)
                private val layout: ConstraintLayout = view.findViewById(R.id.layoutitemrecycler_charactersfragment)
                fun loadAll(character: Caracter){
                    image.load(character.image){
                        transformations(CircleCropTransformation())
                        diskCachePolicy(CachePolicy.ENABLED)
                        memoryCachePolicy(CachePolicy.ENABLED)
                        error(R.drawable.ic_baseline_error_24)
                        placeholder(R.drawable.ic_baseline_replay_24)
                    }
                    name.text = character.name
                    characteristics.text = character.status
                    onClicked(character)
                }
                private fun onClicked(character: Caracter){
                    layout.setOnClickListener{
                        listenerPlace.clickedOnPlace(character, this.adapterPosition)
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
        ViewHolder {
            val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.itemrecycler_charactersfragment, parent, false)
            return CaracterAdapter.ViewHolder(view, listener)
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.loadAll(personajes[position])
    }

    override fun getItemCount(): Int = personajes.size
}