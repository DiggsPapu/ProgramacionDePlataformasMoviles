package com.example.mainactivity.classes

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Caracter(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val species: String,
    val status: String,
    val gender: String,
    val image: String = ""

)

