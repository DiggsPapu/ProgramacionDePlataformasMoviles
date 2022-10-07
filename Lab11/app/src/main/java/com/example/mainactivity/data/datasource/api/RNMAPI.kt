package com.example.mainactivity.data.datasource.api

import com.example.mainactivity.data.datasource.model.onecharacter.AllAssetsForOneCharacterResponse
import com.example.mainactivity.data.datasource.model.variouscharacters.AllAssetsForAllResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RNMAPI {
    @GET("/api/character/")
    fun getCharacters(
    ): Call<AllAssetsForAllResponse>
    @GET("/api/character/{id}")
    fun getCharacter(
        @Path("id") id:String
    ): Call<AllAssetsForOneCharacterResponse>

}