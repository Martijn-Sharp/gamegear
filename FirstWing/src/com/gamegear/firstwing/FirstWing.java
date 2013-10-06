package com.gamegear.firstwing;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.gamegear.firstwing.screens.ExtendedLevelScreen;
import com.gamegear.firstwing.screens.HelpScreen;
import com.gamegear.firstwing.screens.MainMenu;
import com.gamegear.firstwing.screens.OptionsScreen;
import com.gamegear.firstwing.screens.Splash;
import com.gamegear.firstwing.screens.UpgradeScreen;

public class FirstWing extends Game {
	public static AssetManager manager = new AssetManager();
	public static Options options = new Options();
	public static Stats stats;
	public static AudioManager audio;
	public GoogleInterface platformInterface;
	
	//Screens
	public ExtendedLevelScreen 	extLevelScreen;
	public MainMenu 			mainScreen;
	public OptionsScreen 		optionsScreen;
	public UpgradeScreen 		upgradeScreen;
	
	
	public FirstWing(GoogleInterface aInterface){
		platformInterface = aInterface;
		platformInterface.Login();	
	}
	
	@Override
	public void create() {
		setScreen(new Splash(this));
		
		stats = new Stats(this);
		audio = new AudioManager();
		
		//Create all screens
		extLevelScreen = new ExtendedLevelScreen(this);
		mainScreen = new MainMenu(this);
		optionsScreen = new OptionsScreen(this);
		upgradeScreen = new UpgradeScreen(this);
	}
	
	@Override
	public void dispose()
	{
		audio.dispose();
	}
}
