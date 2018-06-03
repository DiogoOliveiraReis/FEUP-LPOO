package com.dor.pkmn.desktop;


import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.Files;
import com.dor.screen.Main;
import com.dor.screen.MenuScreen;
import com.dor.screen.Pkmn;


public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Pkmn";
		config.addIcon("icon.png", Files.FileType.Internal);
		config.height = 720;
		config.width = 1280;
		config.vSyncEnabled = true;
		config.resizable = false;
		new LwjglApplication(new Main(), config);
	}
}

