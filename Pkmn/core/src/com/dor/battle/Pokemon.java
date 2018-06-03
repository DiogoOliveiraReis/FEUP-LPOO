package com.dor.battle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.badlogic.gdx.graphics.Texture;
import com.dor.pkmn.Character;

public class Pokemon
{
    private Character trainer;
    private String name;
    private int level;
    private int currentHitpoints;
    private ArrayList<Move> moves = new ArrayList<Move>(4);

    public Pokemon(Character trainer, String name, ArrayList<Move> movs)
    {
        this.trainer = trainer;
        this.name = name;
        this.level = 5;
        currentHitpoints = 100;
        this.moves = movs;

    }
}
