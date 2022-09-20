package com.example.mainactivity

import java.io.Serializable

data class Character (
    val name: String,
    val species: String,
    val status: String,
    val gender: String,
    val image: String = ""
):Serializable
