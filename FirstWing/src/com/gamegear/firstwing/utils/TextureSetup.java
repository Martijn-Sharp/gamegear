package com.gamegear.firstwing.utils;

import com.badlogic.gdx.tools.imagepacker.TexturePacker2;

public class TextureSetup {
	public static void main(String[] args) {
//		TexturePacker2.process("D:/School/Minor/Local/FirstWing-images/dynamic", "D:/School/Minor/Local/FirstWing-android/assets/textures", "dyntextures.atlas");
//		TexturePacker2.process("D:/School/Minor/Local/FirstWing-images/static", "D:/School/Minor/Local/FirstWing-android/assets/textures", "statextures.atlas");
		
		TexturePacker2.process("D:/FirstWing/gamegear/FirstWing-images/dynamic", "D:/FirstWing/gamegear/FirstWing-android/assets/textures", "dyntextures.atlas");
		TexturePacker2.process("D:/FirstWing/gamegear/FirstWing-images/static", "D:/FirstWing/gamegear/FirstWing-android/assets/textures", "statextures.atlas");
		TexturePacker2.process("D:/FirstWing/gamegear/FirstWing-images/ui", "D:/FirstWing/gamegear/FirstWing-android/assets/ui", "uiskin.atlas");
	}
}
