package com.example.mainactivity.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.CachePolicy
import coil.transform.CircleCropTransformation
import com.example.mainactivity.database.Character


import com.example.mainactivity.R

class CharacterAdapter(
    private val characters:MutableList<Character>, private val placeListener: CharactersF
    ):
    RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {
    interface CharactersF {fun onCharacterClicked(data: Character, position: Int)}
    class ViewHolder(private val view: View, private val listener: CharactersF):RecyclerView.ViewHolder(view){
        private val image:ImageView = view.findViewById<ImageView>(R.id.ivchar_charactersFragment)
        private val name:TextView = view.findViewById<TextView>(R.id.name_char_charactersFragment)
        private val characteristics:TextView = view.findViewById<TextView>(R.id.characteristics_char_charactersFragment)
        private val Layout1: ConstraintLayout  = view.findViewById<ConstraintLayout>(R.id.layoutitemrecycler_charactersfragment)
        private lateinit var place: Character
        fun bind(character: Character){
            this.place = character
            name.text = place.name
            (place.species + " - " + place.status).also { characteristics.text = it }
            image.load(character.image){
                transformations(CircleCropTransformation())
                diskCachePolicy(CachePolicy.DISABLED)
                memoryCachePolicy(CachePolicy.DISABLED)
                error(R.drawable.ic_baseline_error_24)
                placeholder(R.drawable.ic_baseline_replay_24)
            }
        }
        private fun setListeners() {
            Layout1.setOnClickListener{
                listener.onCharacterClicked(place, this.adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.itemrecycler_charactersfragment, parent, false)
        return ViewHolder(view, placeListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)
    }

    override fun getItemCount(): Int = characters.size
}