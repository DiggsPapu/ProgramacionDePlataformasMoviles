package com.example.mainactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import org.w3c.dom.Text

class CharacterAdapter(private val characters:MutableList<Character>): RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.itemrecycler_charactersfragment, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)
    }

    override fun getItemCount(): Int = characters.size
    class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val image = view.findViewById<ImageView>(R.id.ivchar_charactersFragment)
        private val name = view.findViewById<TextView>(R.id.name_char_charactersFragment)
        private val characteristics = view.findViewById<TextView>(R.id.characteristics_char_charactersFragment)

        fun bind(character:Character){
            image.load(character.image)
            name.text = character.name
            characteristics.text = character.status

        }
    }
}