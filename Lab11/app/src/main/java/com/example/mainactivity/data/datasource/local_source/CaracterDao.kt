package com.example.mainactivity.data.datasource.local_source

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mainactivity.classes.Caracter

interface CaracterDao {
    @Delete
    suspend fun deleteCharacter(caracter: Caracter)
    @Insert
    suspend fun insertCharacter(caracter: Caracter)
    @Update
    suspend fun updateCharacter(caracter: Caracter)
    @Query("Delete from Caracter")
    suspend fun deleteAll()

}