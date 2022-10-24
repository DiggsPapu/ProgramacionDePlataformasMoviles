package com.example.mainactivity.data.datasource.local_source

import androidx.room.*
import com.example.mainactivity.classes.Caracter
@Dao
interface CaracterDao {
    @Delete
    suspend fun deleteCharacter(caracter: Caracter):Int
    @Insert
    suspend fun insertCharacter(caracter: Caracter)
    @Update
    suspend fun updateCharacter(caracter: Caracter)
    @Query("Delete from Caracter")
    suspend fun deleteAll()
    @Query("Select * from caracter")
    suspend fun getCaracters():List<Caracter>
    @Query("Select * from caracter where caracter.id= :caracterId")
    suspend fun getCaracter(caracterId:Int):Caracter
}