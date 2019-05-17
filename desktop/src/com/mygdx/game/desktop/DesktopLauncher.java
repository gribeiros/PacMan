package com.mygdx.game.desktop;	

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		  LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
	      config.title = "Pacman";
	      config.width = 768;
	      config.height = 512;
	      new LwjglApplication(new MyGdxGame(), config);
	}
}
