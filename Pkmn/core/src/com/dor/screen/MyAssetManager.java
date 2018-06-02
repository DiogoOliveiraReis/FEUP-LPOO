package com.dor.screen;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SkinLoader.SkinParameter;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class MyAssetManager
{
    public final AssetManager manager = new AssetManager();

    public void queueAddSkin()
    {
        SkinParameter parameter = new SkinParameter(ScreenSettings.skinAtlas);
        manager.load(ScreenSettings.skin,Skin.class,parameter);
    }
}