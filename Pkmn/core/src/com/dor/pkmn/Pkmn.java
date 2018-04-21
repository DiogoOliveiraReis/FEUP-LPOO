package com.dor.pkmn;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dor.controller.PlayerController;

public class Pkmn extends ApplicationAdapter {
	private TileMap map;
	private PlayerController playerController;
	private Player player;
	private Camera camera;
	SpriteBatch batch;
	Texture img;
	Texture img2;
	
	@Override
	public void create ()
	{
		batch = new SpriteBatch();
		img = new Texture("player_south_stand.png");
		img2 = new Texture("grass.png");
		map = new TileMap(15, 15);
		player = new Player(map,0, 0);
		camera = new Camera();
		playerController = new PlayerController(player);
	}

	@Override
	public void render ()
	{
		camera.update(player.getX()+0.5f,player.getY()+0.5f);
		batch.begin();
		float startingX = Gdx.graphics.getWidth()/2 - camera.getCameraX()*Settings.SCALED_TILE_SIZE;
		float startingY = Gdx.graphics.getHeight()/2 - camera.getCameraY()*Settings.SCALED_TILE_SIZE;
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		for (int i = 0; i < map.getX(); i++)
		{
			for (int j = 0; j < map.getY(); j++)
			{
				batch.draw(img2,startingX+i*Settings.SCALED_TILE_SIZE,startingY+j*Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE);
			}
		}
		batch.draw(img, startingX+player.getX()*Settings.SCALED_TILE_SIZE, startingY+player.getY()*Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE, Settings.SCALED_TILE_SIZE);
		Gdx.input.setInputProcessor(playerController);
		batch.end();
	}

	@Override
	public void dispose ()
	{
		batch.dispose();
		img.dispose();
	}
}