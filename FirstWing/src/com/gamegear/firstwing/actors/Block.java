package com.gamegear.firstwing.actors;

import com.badlogic.gdx.math.Vector2;

public class Block extends Actor {

	public static final float SIZE = 1f;

	public Block(Vector2 pos) {
		this.position = pos;
		this.bounds.setX(pos.x);
		this.bounds.setY(pos.y);
		this.bounds.width = SIZE;
		this.bounds.height = SIZE;
	}
}
