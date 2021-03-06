package com.libgdx.battlecommander.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.libgdx.battlecommander.BattleCommander;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "BATTLE COMMANDER";
		config.width = 1280;
		config.height = 720;
		
		//Ryan's temp configs:
		config.resizable = false;
		config.backgroundFPS = 30;
		config.foregroundFPS = 60;
		config.useGL30 = true;
		
		new LwjglApplication(new BattleCommander(), config);
	}
}
