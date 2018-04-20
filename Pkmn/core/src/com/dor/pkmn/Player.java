package com.dor.pkmn;

public class Player extends Character {

    public Player(TileMap map, int x, int y)
    {
        super(map, x, y);
        map.getTile(x,y).setCharacter(this);
    }
}