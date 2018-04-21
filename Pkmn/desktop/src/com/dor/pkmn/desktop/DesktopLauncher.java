package com.dor.pkmn.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.Files;
import com.dor.pkmn.Pkmn;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.addIcon("icon.png", Files.FileType.Internal);
		config.height = 720;
		config.width = 1280;
		config.vSyncEnabled = true;
		config.resizable = false;
		new LwjglApplication(new Pkmn(), config);
	}
}