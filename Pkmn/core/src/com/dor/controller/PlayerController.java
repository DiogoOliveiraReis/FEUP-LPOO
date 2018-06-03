package com.dor.controller;

import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dor.pkmn.Player;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.dor.screen.BattleScreen;

public class PlayerController extends InputAdapter{

    private Player player;
    private boolean brockDialog = false;
    private boolean npc1Dialog = false;
    private boolean pokemonBattle = false;

    public PlayerController(Player P)
    {
        this.player = P;
    }

    public boolean keyDown(int keycode)
    {
        if (keycode == Input.Keys.UP)
        {
            player.move(0,1);
        }
        if (keycode == Input.Keys.DOWN)
        {
            player.move(0,-1);
        }
        if (keycode == Input.Keys.RIGHT)
        {
            player.move(1,0);
        }
        if (keycode == Input.Keys.LEFT)
        {
            player.move(-1,0);
        }
        if (keycode == Input.Keys.Z)
        {
            if ((player.getX() == 3 && player.getY() == 2))
            {
                brockDialog = true;
            }
            else {
                brockDialog = false;
            }
        }
        if (keycode == Input.Keys.Z)
        {
            if ((player.getX() == 35 && player.getY() == 4))
            {
                npc1Dialog = true;
            }
            else {
                npc1Dialog = false;
            }
        }
        if (keycode == Input.Keys.X)
        {
            if (player.getX() == 38 && player.getY() == 5)
            {
                pokemonBattle = true;
            }
            else pokemonBattle = false;
        }
        return false;
    }
    public boolean getBrockDialog()
    {
        return brockDialog;
    }
    public boolean resetBrockDialog()
    {
        if (brockDialog)
        {
            brockDialog = false;
        }
        return brockDialog;
    }
    public boolean getNPC1Dialog()
    {
        return npc1Dialog;
    }
    public boolean resetNPC1Dialog()
    {
        if (npc1Dialog)
        {
            npc1Dialog = false;
        }
        return npc1Dialog;
    }
    public boolean getPokemonBattle()
    {
        return pokemonBattle;
    }
    public boolean resetPokemonBattle()
    {
        if (pokemonBattle)
        {
            pokemonBattle = false;
        }
        return pokemonBattle;
    }
}