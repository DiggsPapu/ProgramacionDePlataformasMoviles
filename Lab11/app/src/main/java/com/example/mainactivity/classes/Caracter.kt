package com.example.mainactivity.classes

import androidx.room.PrimaryKey

data class Caracter(
    @PrimaryKey
    val id:Int,
    val name:String,
    val species: String,
    val status: String,
    val gender: String,
    val image: String = ""

)

