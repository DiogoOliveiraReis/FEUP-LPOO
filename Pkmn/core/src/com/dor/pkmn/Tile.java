package com.dor.pkmn;

public class Tile {

    private TERRAIN Terrain;
    private Character Character;

    public Tile(TERRAIN Terrain)
    {
        this.Terrain = Terrain;
    }

    public TERRAIN getTerrain()
    {
        return Terrain;
    }

    public Character getCharacter()
    {
        return Character;
    }
    public void setCharacter(Character Character)
    {
        this.Character = Character;
    }
}