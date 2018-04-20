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
	SpriteBatch batch;
	Texture img;
	Texture img2;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("player_south_stand.png");
		img2 = new Texture("grass.png");
		map = new TileMap(10, 10);
		player = new Player(map,1, 1);
		playerController = new PlayerController(player);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		for (int i = 0; i < map.getX(); i++)
		{
			for (int j = 0; j < map.getY(); j++)
			{
				batch.draw(img2,i*25,j*25);
			}
		}
		batch.draw(img, player.getX()*25, player.getY()*25);
		Gdx.input.setInputProcessor(playerController);
		batch.end();

	}
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}