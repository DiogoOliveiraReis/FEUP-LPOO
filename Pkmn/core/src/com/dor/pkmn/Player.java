package com.dor.pkmn;

import com.dor.battle.Pokemon;

import java.util.ArrayList;

public class Player extends Character {

    private ArrayList<Pokemon> pokemons;

    public Player(TileMap map, int x, int y)
    {
        super(map, x, y);
        map.getTile(x,y).setCharacter(this);
        pokemons = new ArrayList<Pokemon>(6);
    }



    public void addPokemon(Pokemon p){

        if(pokemons.size() < 6){


            pokemons.add(p);

        }

        return;

    }


    public ArrayList<Pokemon> getPokemons() {

        return pokemons;

    }
}