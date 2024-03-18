package com.example.pokedex.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import com.example.pokedex.model.Pokemon;
import java.util.List;

@Dao
public interface PokemonDao {
    @Query("SELECT * FROM pokemon WHERE name LIKE '%' || :keyword || '%'")
    LiveData<List<Pokemon>> search(String keyword);

    @Query("SELECT * FROM pokemon")
    LiveData<List<Pokemon>> getAll();
}
