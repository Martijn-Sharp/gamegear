package com.gamegear.firstwing;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.gamegear.firstwing.screens.Splash;

public class FirstWing extends Game {
	public static AssetManager manager = new AssetManager();
	public static Options options = new Options();
	public static Stats stats;
	public GoogleInterface platformInterface;
	
	public FirstWing(GoogleInterface aInterface){
		platformInterface = aInterface;
		platformInterface.Login();
	}
	
	@Override
	public void create() {
		setScreen(new Splash(this));
		stats = new Stats(this);
	}
}
