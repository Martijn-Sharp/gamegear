package com.gamegear.firstwing.actors;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.World;
import com.gamegear.firstwing.actors.json.DynamicActor;

public abstract class MoveableActor extends Actor {
	private float speed;
	
	/** @param Speed
	 * @param Scale
	 * @param Width
	 * @param Height
	 * @param Position */
	public MoveableActor(DynamicActor actor, Vector2 position, World world, Filter filter) {
		super(actor, BodyType.DynamicBody, position, world, filter);
		this.speed = actor.Speed;
	}
	
	public float getSpeed() {
		return this.speed;
	}
	
	public void setSpeed(float speed){
		this.speed = speed;
	}
	
	@Override
	protected abstract void loadTextures();
	
	@Override
	protected abstract void draw();
}
