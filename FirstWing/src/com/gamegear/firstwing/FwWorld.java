package com.gamegear.firstwing;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.gamegear.firstwing.actors.*;
import com.gamegear.firstwing.levels.Level;

public class FwWorld {

	static final float WORLD_TO_BOX=0.01f;
	static final float BOX_TO_WORLD=100f;
	static final float BOX_STEP=1/120f;
	float accumulator;
	
	World world;
	/** Our player controlled hero **/
	Bob bob;
	/** A world has a level through which Bob needs to go through **/
	Level level;
	
	/** The collision boxes **/
	Array<Rectangle> collisionRects = new Array<Rectangle>();

	// Getters -----------
	
	public Array<Rectangle> getCollisionRects() {
		return collisionRects;
	}
	
	public Bob getBob() {
		return bob;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public World getWorld() {
		return world;
	}

	// --------------------
	public FwWorld(String levelPath) {
		this.world = new World(new Vector2(0, 0), true);
		this.createWorld(levelPath);
	}
	
	public float ConvertToBox(float x){
	    return x * WORLD_TO_BOX;
	}
	
	private void createWorld(String levelPath) {
		this.level = new Level(this.world, levelPath);
		this.bob = this.level.getPlayer();
	}
}