package com.example.pokedex.fragments.menu.pokemonmenu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokedex.R;
import com.example.pokedex.model.Pokemon;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PokMenuAdapter extends RecyclerView.Adapter<PokMenuAdapter.PokemonViewHolder> {
    private List<Pokemon> pokemonList;

    public PokMenuAdapter() {
        this.pokemonList = new ArrayList<>();
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
        holder.tvNumber.setText(pokemon.id);
        holder.tvName.setText(pokemon.name);
        Picasso.get().load(pokemon.image).into(holder.ivPokemon);
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }
}
