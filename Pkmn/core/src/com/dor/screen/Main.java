package com.dor.screen;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dor.controller.PlayerController;
import com.dor.screen.GameScreen;
import com.dor.controller.PlayerController;


public class Main extends Game
{
    private SpriteBatch batch;
    public Viewport screenPort;

    @Override
    public void create ()
    {
        batch = new SpriteBatch();
        OrthographicCamera camera = new OrthographicCamera();
        camera.setToOrtho(false);
        screenPort = new ScreenViewport();
        this.setScreen(new MenuScreen(this));
    }

    public void gotoNewScreen()
    {
        this.setScreen(new GameScreen(this));
    }


    public void gotoContinueScreen()
    {

    }

    public void gotoExitScreen()
    {
        System.exit(0);
    }


    public void switchToBattle()
    {

    }


    @Override
    public void render ()
    {
        super.render();
    }

    @Override
    public void dispose ()
    {
        super.dispose();
    }
}
