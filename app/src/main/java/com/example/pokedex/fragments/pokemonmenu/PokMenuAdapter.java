package com.example.pokedex.fragments.pokemonmenu;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokedex.MainActivity;
import com.example.pokedex.R;
import com.example.pokedex.model.Pokemon;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PokMenuAdapter extends RecyclerView.Adapter<PokMenuAdapter.PokemonViewHolder> {
    private List<Pokemon> pokemonList;
    private View _view;

    public PokMenuAdapter(View view) {
        this.pokemonList = new ArrayList<>();
        this._view = view;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
        notifyDataSetChanged();
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder {
        TextView tvNumber;
        TextView tvName;
        ImageView ivPokemon;

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNumber = itemView.findViewById(R.id.numberPokemon);
            tvName = itemView.findViewById(R.id.namePokemon);
            ivPokemon = itemView.findViewById(R.id.imageView);
        }
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.res_item, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon pokemon = pokemonList.get(position);
        holder.tvNumber.setText("№ " + pokemon.id.toString());
        holder.tvName.setText(pokemon.name);
        Picasso.get().load(pokemon.image).into(holder.ivPokemon);
        //NavController controller = holder.itemView.getContext();
        holder.itemView.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("pokemon", pokemon);
            Navigation.findNavController(_view)
                    .navigate(R.id.action_pokemonMenuFragment2_to_pokemonCardFragment, bundle);
        });
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }
}
