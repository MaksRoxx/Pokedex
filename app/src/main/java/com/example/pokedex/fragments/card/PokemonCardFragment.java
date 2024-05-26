package com.example.pokedex.fragments.card;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pokedex.R;
import com.example.pokedex.databinding.FragmentPokemonCardBinding;
import com.example.pokedex.model.Pokemon;
import com.squareup.picasso.Picasso;

public class PokemonCardFragment extends Fragment {
    FragmentPokemonCardBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPokemonCardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        assert getArguments() != null;
        Pokemon pokemon = getArguments().getSerializable("pokemon", Pokemon.class);
        assert pokemon != null;
        bindPokemon(pokemon);

        binding.backArrow.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_pokemonCardFragment_to_pokemonMenuFragment2);
        });
    }

    private void bindPokemon(Pokemon pokemon) {
        Picasso.get().load(pokemon.image).into(binding.pokemonImage);
        binding.pokemonAbilities.setText("Abilities: " + pokemon.abilities);
        binding.pokemonCategory.setText("Category: " + pokemon.category);
        binding.pokemonDescribe.setText(pokemon.describe);
        binding.pokemonName.setText(pokemon.name);
        binding.pokemonHeight.setText("Height: " + pokemon.height);
        binding.pokemonWeight.setText("Weight: " + pokemon.weight);
        binding.pokemonType.setText("Pokemon type: " + pokemon.type);
    }
}