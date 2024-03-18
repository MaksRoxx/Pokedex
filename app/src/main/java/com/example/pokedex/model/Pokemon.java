package com.example.pokedex.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pokemon")
public class Pokemon {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "image")
    public String image;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "describe")
    public String describe;
    @ColumnInfo(name = "height")
    public String height;
    @ColumnInfo(name = "weight")
    public String weight;
    @ColumnInfo(name = "category")
    public String category;
    @ColumnInfo(name = "abilities")
    public String abilities;
    @ColumnInfo(name = "type")
    public String type;
}