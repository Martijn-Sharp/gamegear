package com.gamegear.firstwing.utils;

import com.badlogic.gdx.tools.imagepacker.TexturePacker2;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2.Settings;

public class TextureSetup {
	public static void main(String[] args) {
		Settings settings = new Settings();
		settings.maxWidth = 512;
		settings.maxHeight = 512;

		TexturePacker2.process(settings, "../FirstWing-images/dynamic", "D:/FirstWing/FirstWing-android/assets/textures", "dyntextures.atlas");
		TexturePacker2.process(settings, "../FirstWing-images/ui", "D:/FirstWing/FirstWing-android/assets/ui", "uiskin.atlas");
		TexturePacker2.process(settings, "../FirstWing-images/static/blue", "../FirstWing-android/assets/textures/blue", "textures.atlas");
		TexturePacker2.process(settings, "../FirstWing-images/static/green", "../FirstWing-android/assets/textures/green", "textures.atlas");
		TexturePacker2.process(settings, "../FirstWing-images/static/lightblue", "../FirstWing-android/assets/textures/lightblue", "textures.atlas");
		TexturePacker2.process(settings, "../FirstWing-images/static/orange", "../FirstWing-android/assets/textures/orange", "textures.atlas");
		TexturePacker2.process(settings, "../FirstWing-images/static/other", "../FirstWing-android/assets/textures/other", "textures.atlas");
		TexturePacker2.process(settings, "../FirstWing-images/static/purple", "../FirstWing-android/assets/textures/purple", "textures.atlas");
		TexturePacker2.process(settings, "../FirstWing-images/static/red", "../FirstWing-android/assets/textures/red", "textures.atlas");
		TexturePacker2.process(settings, "../FirstWing-images/static/yellow", "../FirstWing-android/assets/textures/yellow", "textures.atlas");
	}
}
