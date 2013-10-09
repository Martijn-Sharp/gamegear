package com.gamegear.firstwing.utils;

import com.badlogic.gdx.tools.imagepacker.TexturePacker2;

public class TextureSetup {
	public static void main(String[] args) {
		TexturePacker2.process("D:/School/Minor/Local/FirstWing-images/dynamic", "D:/School/Minor/Local/FirstWing-android/assets/textures", "dyntextures.atlas");
		TexturePacker2.process("D:/School/Minor/Local/FirstWing-images/static", "D:/School/Minor/Local/FirstWing-android/assets/textures", "statextures.atlas");
//		TexturePacker2.process("D:/School/Minor/Local/FirstWing-android/assets/ui/processing", "D:/School/Minor/Local/FirstWing-android/assets/ui", "ui.atlas");
		
//		TexturePacker2.process("D:/FirstWing/FirstWing-images/dynamic", "D:/FirstWing/FirstWing-android/assets/textures", "dyntextures.atlas");
//		TexturePacker2.process("D:/FirstWing/FirstWing-images/static", "D:/FirstWing/FirstWing-android/assets/textures", "statextures.atlas");
//		TexturePacker2.process("D:/FirstWing/FirstWing-images/ui", "D:/FirstWing/FirstWing-android/assets/ui", "uiskin.atlas");
	}
}
