package com.example.mainactivity.data.datasource.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\'\u00a8\u0006\t"}, d2 = {"Lcom/example/mainactivity/data/datasource/api/RNMAPI;", "", "getCharacter", "Lretrofit2/Call;", "Lcom/example/mainactivity/data/datasource/model/onecharacter/AllAssetsForOneCharacterResponse;", "id", "", "getCharacters", "Lcom/example/mainactivity/data/datasource/model/variouscharacters/AllAssetsForAllResponse;", "app_debug"})
public abstract interface RNMAPI {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/api/character/")
    public abstract retrofit2.Call<com.example.mainactivity.data.datasource.model.variouscharacters.AllAssetsForAllResponse> getCharacters();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/api/character/{id}")
    public abstract retrofit2.Call<com.example.mainactivity.data.datasource.model.onecharacter.AllAssetsForOneCharacterResponse> getCharacter(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "id")
    java.lang.String id);
}