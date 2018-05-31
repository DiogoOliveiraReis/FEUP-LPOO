package com.dor.controller;

import com.dor.pkmn.Player;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class PlayerController extends InputAdapter{

    private Player player;
    private boolean brockDialog = false;

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
            if (player.getX() == 3 && player.getY() == 2)
            {
                brockDialog = true;
            }
            else brockDialog = false;
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
}