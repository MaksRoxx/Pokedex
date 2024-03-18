package com.example.pokedex.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pokedex.model.Pokemon;

@Database(entities = {Pokemon.class}, version = 1, exportSchema = true)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public abstract PokemonDao pokemonDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "pokemon.db").createFromAsset("database/pokemon.db").build();
        }
        return instance;
    }
}