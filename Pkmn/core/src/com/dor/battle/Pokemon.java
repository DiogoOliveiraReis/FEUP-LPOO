package com.dor.battle;

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
    private Move[] moves = new Move[4];

    public Pokemon(Character trainer, String name)
    {
        this.trainer = trainer;
        this.name = name;
        this.level = 5;
        currentHitpoints = 100;
    }
}
