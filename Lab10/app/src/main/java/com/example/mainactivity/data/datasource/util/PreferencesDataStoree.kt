package com.example.mainactivity.data.datasource.util
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
const val settingsname = "settings"
const val mail = "email"
val Context.dataStoree: DataStore<Preferences> by preferencesDataStore(name = settingsname)

suspend fun DataStore<Preferences>.saveValue(key: String, value: String) {
    val dataStoreKey = stringPreferencesKey(key)
    edit { settings ->
        settings[dataStoreKey] = value
    }
}

suspend fun DataStore<Preferences>.getValue(key: String): String? {
    val dataStoreKey = stringPreferencesKey(key)
    val preferences = data.first()
    return preferences[dataStoreKey]
}

suspend fun DataStore<Preferences>.removeValue(key: String) {
    val dataStoreKey = stringPreferencesKey(key)
    edit { settings ->
        settings.remove(dataStoreKey)
    }
}