package com.dor.screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


public class MenuScreen implements Screen
{
    // private SpriteBatch spriteBatch;
    final Main game;
    private Texture wallpaper;
    private Texture wallpaper2;
    private Skin mySkin;
    private Stage stage;
    SpriteBatch batch;


    public MenuScreen(final Main game)
    {
        this.game = game;
        batch = new SpriteBatch();
        wallpaper = new Texture(Gdx.files.internal("mainMenuWallpaper.jpg"));
        wallpaper2 = new Texture(Gdx.files.internal("pokemonLetters.png"));
        stage = new Stage(game.screenPort);
        mySkin = new Skin(Gdx.files.internal(ScreenSettings.skin));
        Gdx.input.setInputProcessor(stage);
        Button newBtn = new TextButton("New Game",mySkin,"small");
        newBtn.setSize(ScreenSettings.col_width*2,ScreenSettings.row_height);
        newBtn.setPosition(ScreenSettings.centerX - newBtn.getWidth()/2,ScreenSettings.centerY);
        newBtn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.gotoNewScreen();
                return true;}

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        Button continueBtn = new TextButton("Continue",mySkin,"small");
        continueBtn.setSize(ScreenSettings.col_width*2,ScreenSettings.row_height);
        continueBtn.setPosition(ScreenSettings.centerX - continueBtn.getWidth()/2,newBtn.getY() - ScreenSettings.row_height - 15);
        continueBtn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.gotoContinueScreen();
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        Button exitBtn = new TextButton("Exit",mySkin,"small");
        exitBtn.setSize(ScreenSettings.col_width*2,ScreenSettings.row_height);
        exitBtn.setPosition(ScreenSettings.centerX - exitBtn.getWidth()/2,newBtn.getY() - ScreenSettings.row_height - 150);
        exitBtn.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.gotoExitScreen();
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });

        stage.addActor(newBtn);
        stage.addActor(continueBtn);
        stage.addActor(exitBtn);
    }


    @Override
    public void show()
    {

    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        batch.begin();
        batch.draw(wallpaper,0,0);
        batch.draw(wallpaper2,0,200);
        batch.end();
        stage.draw();
    }

    @Override
    public void resize(int width, int height)
    {
        game.screenPort.update(width,height);
    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void hide()
    {

    }

    @Override
    public void dispose()
    {
        mySkin.dispose();
        stage.dispose();
    }
}
