package com.gamegear.firstwing;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gamegear.firstwing.screens.ExtendedLevelScreen;
import com.gamegear.firstwing.screens.MainMenu;
import com.gamegear.firstwing.screens.OptionsScreen;
import com.gamegear.firstwing.screens.Splash;
import com.gamegear.firstwing.screens.UpgradeScreen;

public class FirstWing extends Game {
	public static AssetManager manager;
	public static Options options;
	public static Stats stats;
	public static AudioManager audio;
	public GoogleInterface platformInterface;
	public static ObjectMapper mapper;
	
	//Screens
	public ExtendedLevelScreen 	extLevelScreen;
	public MainMenu 			mainScreen;
	public OptionsScreen 		optionsScreen;
	public UpgradeScreen 		upgradeScreen;
	
	
	public FirstWing(GoogleInterface aInterface){
		this.platformInterface = aInterface;
		this.platformInterface.Login();	
	}
	
	@Override
	public void create() {
		this.setScreen(new Splash(this));
		
		stats = new Stats(this);
		audio = new AudioManager();
		manager = new AssetManager();
		options = new Options();
		TextureMgr.initiate();
		
		//Create all screens
		this.extLevelScreen = new ExtendedLevelScreen(this);
		this.mainScreen = new MainMenu(this);
		this.optionsScreen = new OptionsScreen(this);
		this.upgradeScreen = new UpgradeScreen(this);
		
		mapper = new ObjectMapper();
	}
	
	@Override
	public void dispose()
	{
		audio.dispose();
	}
}
