package com.example.pokedex.fragments.pokemonmenu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.example.pokedex.R;
import com.example.pokedex.model.Pokemon;
import com.example.pokedex.viewmodel.PokemonViewModel;

import java.util.List;

public class PokemonMenuFragment extends Fragment {
    private RecyclerView rv;
    private PokMenuAdapter adapter;
    private PokemonViewModel pokemonViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pokemon_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv = view.findViewById(R.id.recView);
        rv.setLayoutManager(new GridLayoutManager(getContext(), 2));
        adapter = new PokMenuAdapter();
        rv.setAdapter(adapter);

        pokemonViewModel = new ViewModelProvider(requireActivity()).get(PokemonViewModel.class);
        pokemonViewModel.getAllPokemon().observe(getViewLifecycleOwner(), pokemonList -> adapter.setPokemonList(pokemonList));

        SearchView searchView = view.findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                pokemonViewModel.searchPokemon(newText).observe(requireActivity(), new Observer<List<Pokemon>>() {
                    @Override
                    public void onChanged(List<Pokemon> pokemons) {
                        adapter.setPokemonList(pokemons);
                    }
                });
                return true;
            }
        });
    }
}