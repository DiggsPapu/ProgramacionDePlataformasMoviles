package com.example.mainactivity.data.datasource.local_source;

import java.lang.System;

@androidx.room.Database(entities = {com.example.mainactivity.classes.Caracter.class}, version = 1)
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/example/mainactivity/data/datasource/local_source/CaracterDB;", "Landroidx/room/RoomDatabase;", "()V", "caracterDao", "Lcom/example/mainactivity/data/datasource/local_source/CaracterDao;", "app_debug"})
public abstract class CaracterDB extends androidx.room.RoomDatabase {
    
    public CaracterDB() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.mainactivity.data.datasource.local_source.CaracterDao caracterDao();
}