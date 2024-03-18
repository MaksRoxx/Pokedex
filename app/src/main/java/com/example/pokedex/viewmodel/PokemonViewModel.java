package com.example.pokedex.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.pokedex.model.Pokemon;
import com.example.pokedex.repository.PokemonRepository;
import java.util.List;

public class PokemonViewModel extends AndroidViewModel {
    private PokemonRepository repository;
    private LiveData<List<Pokemon>> allPokemon;

    public PokemonViewModel(Application application) {
        super(application);
        repository = new PokemonRepository(application);
        allPokemon = repository.getAllPokemon();
    }

    public LiveData<List<Pokemon>> getAllPokemon() {
        return allPokemon;
    }

    public LiveData<List<Pokemon>> searchPokemon(String keyword) {
        return repository.searchPokemon(keyword);
    }
}
