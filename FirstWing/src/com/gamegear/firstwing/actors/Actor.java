package com.gamegear.firstwing.actors;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Actor {
	protected Vector2 position = new Vector2();
	protected Rectangle bounds = new Rectangle();
	
	public Vector2 getPosition() {
		return position;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
}
