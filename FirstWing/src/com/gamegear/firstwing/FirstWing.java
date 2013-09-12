package com.gamegear.firstwing;

import com.badlogic.gdx.Game;
import com.gamegear.firstwing.screens.*;

public class FirstWing extends Game {

	@Override
	public void create() {
		setScreen(new GameScreen());
	}
}
