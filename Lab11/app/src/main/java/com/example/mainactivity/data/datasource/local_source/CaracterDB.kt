package com.example.mainactivity.data.datasource.local_source

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CaracterDao::class],
    version = 1
)
abstract class CaracterDB: RoomDatabase() {
    abstract fun caracterDao(): CaracterDao
}