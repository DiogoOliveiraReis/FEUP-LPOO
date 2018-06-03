package com.dor.pkmn;

public class Camera {


    private float cameraX = 0f;
    private float cameraY = 0f;


    public void update(float x, float y)
    {
        this.cameraX = x;
        this.cameraY = y;
    }


    public float getCameraX()
    {
        return cameraX;
    }


    public float getCameraY()
    {
        return cameraY;
    }
    
}