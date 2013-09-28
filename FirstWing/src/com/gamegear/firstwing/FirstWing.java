package com.gamegear.firstwing;

import com.badlogic.gdx.Game;

public class FirstWing extends Game {
	@Override
	public void create() {
		setScreen(new Splash(this));
	}
}
