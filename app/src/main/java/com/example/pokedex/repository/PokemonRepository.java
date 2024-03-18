package com.example.pokedex.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;

import com.example.pokedex.data.AppDatabase;
import com.example.pokedex.data.PokemonDao;
import com.example.pokedex.model.Pokemon;

import java.util.List;

public class PokemonRepository {
    private PokemonDao pokemonDao;
    private LiveData<List<Pokemon>> allPokemon;

    public PokemonRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        pokemonDao = db.pokemonDao();
        allPokemon = pokemonDao.getAll();
    }

    public LiveData<List<Pokemon>> getAllPokemon() {
        return allPokemon;
    }

    public LiveData<List<Pokemon>> searchPokemon(String keyword) {
        return pokemonDao.search("%" + keyword + "%");
    }
}
