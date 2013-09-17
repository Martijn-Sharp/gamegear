package com.gamegear.firstwing.utils;

import com.badlogic.gdx.tools.imagepacker.TexturePacker2;

public class TextureSetup {
	public static void main(String[] args) {
		TexturePacker2.process("D:/FirstWing/gamegear/FirstWing-android/assets/images/dynamic", "D:/FirstWing/gamegear/FirstWing-android/assets/textures", "dyntextures.pack");
		TexturePacker2.process("D:/FirstWing/gamegear/FirstWing-android/assets/images/static", "D:/FirstWing/gamegear/FirstWing-android/assets/textures", "statextures.pack");
	}
}
