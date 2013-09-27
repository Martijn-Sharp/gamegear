package com.gamegear.firstwing.actors;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.World;

public abstract class MoveableActor extends Actor {

	public enum State {
		IDLE, DYING, ACCELERATING, BREAKING, LIFTING, DESCENDING
	}
	
	private float speed;
	private State state = State.IDLE;
	private float stateTime = 0;
	
	/** @param Speed
	 * @param Scale
	 * @param Width
	 * @param Height
	 * @param Position */
	public MoveableActor(float speed, float scale, float width, float height, Vector2 position, World world, Filter filter) {
		super(scale, width, height, BodyType.DynamicBody, position, world, filter);
		this.speed = speed;
	}
	
	public float getSpeed() {
		return this.speed;
	}
	
	@Override
	protected abstract void loadTextures();
	
	@Override
	protected abstract void draw();
	
	public State getState() {
		return state;
	}
	
	public void setState(State newState) {
		this.state = newState;
	}
	
	public float getStateTime(){
		return stateTime;
	}
	
	public void setStateTime(float stateTime) {
		this.stateTime = stateTime;
	}
	
	public void update(float delta) {
		stateTime += delta;
		//position.add(velocity.tmp().mul(delta)); 
	}

}
