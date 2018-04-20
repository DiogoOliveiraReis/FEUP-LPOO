package com.dor.controller;

import com.dor.pkmn.Player;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class PlayerController extends InputAdapter{

    private Player player;

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
        return false;
    }
}