package com.dor.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dor.battle.Move;
import com.dor.battle.Pokemon;
import com.dor.controller.PlayerController;
import com.dor.pkmn.Camera;
import com.dor.pkmn.Character;
import com.dor.pkmn.PkmnSettings;
import com.dor.pkmn.Player;
import com.dor.pkmn.TileMap;
import com.dor.screen.Main;

import java.util.ArrayList;

public class GameScreen implements Screen
{
    final Main game;
    private Stage stage;
    private TileMap map;
    private PlayerController playerController;
    private Player player;
    private Character brock;
    private Camera camera;
    private Pokemon goldrus;
    SpriteBatch batch;
    Texture img;
    Texture img2;
    Texture pavement;
    Texture tree;
    Texture house;
    Texture brock_img;
    Texture blastew_img;
    Texture poke_grass;
    Texture borders;
    Texture npc1;
    private BitmapFont font;
    private Pokemon blastew;
    public Viewport screenPort;
    boolean pkmnBattle = false;

    public GameScreen(final Main game)
    {
        this.game = game;
        screenPort = new ScreenViewport();
        stage = new Stage(game.screenPort);
        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();
        img = new Texture("player_south_stand.png");
        img2 = new Texture("grass.png");
        pavement = new Texture("pave.png");
        tree = new Texture("tree.png");
        house = new Texture("house.png");
        brock_img = new Texture("brock.png");
        blastew_img = new Texture("blastew.png");
        poke_grass = new Texture("poke_grass.png");
        borders = new Texture("borders.png");
        npc1 = new Texture("npc1.png");
        map = new TileMap(50, 50);
        player = new Player(map,2, 2);
        brock = new Character(map,3,3);
        camera = new Camera();
        playerController = new PlayerController(player);
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        Move watagun = new Move(50, "Water Gun");
        Move Hypabeam = new Move(120, "Hyper Beam");
        Move Surf = new Move(80, "Surf");
        Move fly = new Move(50, "Fly");
        Move dig = new Move(80, "Dig");
        ArrayList<Move> moveset1 = new ArrayList<Move>(4);
        ArrayList<Move> moveset2 = new ArrayList<Move>(4);
        moveset1.add(watagun); moveset1.add(Hypabeam); moveset1.add(fly); moveset1.add(Surf);
        moveset2.add(watagun); moveset2.add(dig); moveset2.add(fly); moveset2.add(Surf);
        blastew = new Pokemon(player, "Blastew", moveset1);
        goldrus = new Pokemon(null, "goldrus", moveset2);
    }

    @Override
    public void show()
    {

    }

    @Override
    public void render(float delta)
    {
        stage.act();
        camera.update(player.getX()+0.5f,player.getY()+0.5f);
        batch.begin();
        float startingX = Gdx.graphics.getWidth()/2 - camera.getCameraX()* PkmnSettings.SCALED_TILE_SIZE;
        float startingY = Gdx.graphics.getHeight()/2 - camera.getCameraY()* PkmnSettings.SCALED_TILE_SIZE;
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        for (int i = 0; i < map.getX(); i++)
        {
            for (int j = 0; j < map.getY(); j++)
            {
                batch.draw(img2,startingX+i* PkmnSettings.SCALED_TILE_SIZE,startingY+j* PkmnSettings.SCALED_TILE_SIZE, PkmnSettings.SCALED_TILE_SIZE, PkmnSettings.SCALED_TILE_SIZE);
                if(j == 35 && i < 20 || j == 35 && i > 30 || j ==  49 || j == 0 || i == 0 || i == 49){

                    batch.draw(borders,startingX+i* PkmnSettings.SCALED_TILE_SIZE,startingY+j* PkmnSettings.SCALED_TILE_SIZE, PkmnSettings.SCALED_TILE_SIZE, PkmnSettings.SCALED_TILE_SIZE);

                }
                if(i > 35 && j < 35 && j > 0 && i < 49){

                    batch.draw(poke_grass,startingX+i* PkmnSettings.SCALED_TILE_SIZE,startingY+j* PkmnSettings.SCALED_TILE_SIZE, PkmnSettings.SCALED_TILE_SIZE, PkmnSettings.SCALED_TILE_SIZE);
                }
            }
        }
        batch.draw(tree, startingX+5 * PkmnSettings.SCALED_TILE_SIZE,  startingY+5 * PkmnSettings.SCALED_TILE_SIZE, PkmnSettings.SCALED_TILE_SIZE*2, PkmnSettings.SCALED_TILE_SIZE*3);
        batch.draw(tree, startingX+25 * PkmnSettings.SCALED_TILE_SIZE,  startingY+25 * PkmnSettings.SCALED_TILE_SIZE, PkmnSettings.SCALED_TILE_SIZE*2, PkmnSettings.SCALED_TILE_SIZE*3);
        batch.draw(tree, startingX+25 * PkmnSettings.SCALED_TILE_SIZE,  startingY+20 * PkmnSettings.SCALED_TILE_SIZE, PkmnSettings.SCALED_TILE_SIZE*2, PkmnSettings.SCALED_TILE_SIZE*3);
        batch.draw(tree, startingX+38 * PkmnSettings.SCALED_TILE_SIZE,  startingY+40 * PkmnSettings.SCALED_TILE_SIZE, PkmnSettings.SCALED_TILE_SIZE*2, PkmnSettings.SCALED_TILE_SIZE*3);

        batch.draw(house, startingX+10 *PkmnSettings.SCALED_TILE_SIZE,  startingY+5 *PkmnSettings.SCALED_TILE_SIZE,PkmnSettings.SCALED_TILE_SIZE*4,PkmnSettings.SCALED_TILE_SIZE*4);
        batch.draw(house, startingX+20 *PkmnSettings.SCALED_TILE_SIZE,  startingY+5 *PkmnSettings.SCALED_TILE_SIZE,PkmnSettings.SCALED_TILE_SIZE*4,PkmnSettings.SCALED_TILE_SIZE*4);
        batch.draw(house, startingX+10 *PkmnSettings.SCALED_TILE_SIZE,  startingY+10 *PkmnSettings.SCALED_TILE_SIZE,PkmnSettings.SCALED_TILE_SIZE*4,PkmnSettings.SCALED_TILE_SIZE*4);
        batch.draw(house, startingX+20 *PkmnSettings.SCALED_TILE_SIZE,  startingY+10 *PkmnSettings.SCALED_TILE_SIZE,PkmnSettings.SCALED_TILE_SIZE*4,PkmnSettings.SCALED_TILE_SIZE*4);

        batch.draw(img, startingX+player.getX()* PkmnSettings.SCALED_TILE_SIZE, startingY+player.getY()* PkmnSettings.SCALED_TILE_SIZE, PkmnSettings.SCALED_TILE_SIZE, PkmnSettings.SCALED_TILE_SIZE);

        batch.draw(brock_img, startingX+brock.getX()* PkmnSettings.SCALED_TILE_SIZE, startingY+brock.getY()* PkmnSettings.SCALED_TILE_SIZE, PkmnSettings.SCALED_TILE_SIZE, PkmnSettings.SCALED_TILE_SIZE);
        batch.draw(npc1, startingX+35 * PkmnSettings.SCALED_TILE_SIZE,  startingY+5 * PkmnSettings.SCALED_TILE_SIZE, PkmnSettings.SCALED_TILE_SIZE, PkmnSettings.SCALED_TILE_SIZE);
        batch.draw(blastew_img, startingX+38 * PkmnSettings.SCALED_TILE_SIZE,  startingY+5 * PkmnSettings.SCALED_TILE_SIZE, PkmnSettings.SCALED_TILE_SIZE, PkmnSettings.SCALED_TILE_SIZE);

        Gdx.input.setInputProcessor(playerController);

        if (playerController.getBrockDialog())
        {
            font.draw(batch, "Welcome to the world of Pokémon!", startingX+player.getX()* PkmnSettings.SCALED_TILE_SIZE, 120);
            if (playerController.keyDown(Input.Keys.Z))
            {
                playerController.resetBrockDialog();
            }
        }

        if (playerController.getNPC1Dialog())
        {
            font.draw(batch, "Try catching a Pokémon!", startingX+player.getX()* PkmnSettings.SCALED_TILE_SIZE, 120);
            if (playerController.keyDown(Input.Keys.Z))
            {
                playerController.resetNPC1Dialog();
            }
        }

        if (playerController.getPokemonBattle())
        {
            playerController.resetPokemonBattle();
            pkmnBattle = true;
        }

        //batch.draw(house, startingX+20 * PkmnSettings.SCALED_TILE_SIZE,  startingY+5 * PkmnSettings.SCALED_TILE_SIZE, PkmnSettings.SCALED_TILE_SIZE*3, PkmnSettings.SCALED_TILE_SIZE*3);

		/*
		if(player.getX() > 35 && player.getY() < 35){

			if(appear < 4){
				Battle bat = new Battle(player, goldrus);
			}
		}
		*/

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
        stage.dispose();
    }

    public PlayerController getPlayerController()
    {
        return playerController;
    }
}