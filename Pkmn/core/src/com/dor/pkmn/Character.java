package com.dor.pkmn;

public class Character
{
    private Character npc;
    private TileMap map;
    private int x;
    private int y;
    private char oriention;

    public Character(TileMap map, int x, int y)
    {
        this.map = map;
        this.x = x;
        this.y = y;
        this.oriention = 's';
    }

    public boolean move(int dx, int dy)
    {
        if (x+dx >= map.getX() || x+dx > 48)
        {
            return false;
        }
        if (x+dx >= map.getX() || x+dx < 1 || y+dy >= map.getY() || y+dy < 1)
        {
            return false;
        }
        if (map.getTile(x+dx, y+dy).getCharacter() != null)
        {
            return false;
        }
        map.getTile(x,y).setCharacter(null);
        x += dx;
        y += dy;
        map.getTile(x,y).setCharacter(this);
        return true;
    }

    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }

    public void setCharacter(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}