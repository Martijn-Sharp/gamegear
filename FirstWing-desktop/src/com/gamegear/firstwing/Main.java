package com.gamegear.firstwing;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class Main {
	public static void main(String[] args) {
		new LwjglApplication(new FirstWing(new DesktopInterface()), "First Wing", 480, 320, true);
	}
}
