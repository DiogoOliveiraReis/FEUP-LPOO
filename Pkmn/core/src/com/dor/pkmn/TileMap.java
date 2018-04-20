package com.dor.pkmn;

public class TileMap {

    private int x,y;
    private Tile[][] Tiles;

    public TileMap(int x, int y)
    {
        this.x = x;
        this.y = y;
        Tiles = new Tile[x][y];
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
                Tiles[i][j] = new Tile(TERRAIN.GRASS);
        }
    }

    public Tile getTile(int x, int y) {
        return Tiles[x][y];
    }

    public void setTile(Tile Tile, int x, int y) {
        Tiles[x][y] = Tile;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}