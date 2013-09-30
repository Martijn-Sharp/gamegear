package com.gamegear.firstwing;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.gamegear.firstwing.screens.Splash;

public class FirstWing extends Game {
	public static AssetManager manager = new AssetManager();
	public static Options options = new Options();
	
	@Override
	public void create() {
		setScreen(new Splash(this));
	}
}
