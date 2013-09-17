package com.gamegear.firstwing.actors;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.gamegear.firstwing.WorldRenderer;
import com.gamegear.firstwing.actors.Actor;

public class Bob extends Actor {

	public enum State {
		IDLE, DYING, ACCELERATING, BREAKING, LIFTING, DESCENDING
	}
	
	public static final float SPEED = 4f;	// unit per second
	public static final float SIZE = 0.5f; // half a unit
	private static final float RUNNING_FRAME_DURATION = 0.06f;
	
	State state = State.IDLE;
	float stateTime = 0;
	
	private TextureRegion bobIdleRight;
	private TextureRegion bobJumpRight;
	private TextureRegion bobFallRight;
	
	private Animation walkRightAnimation;

	public Bob(Vector2 position, World world) {
		super(4f, 2, 0.5f, 0.5f, BodyType.DynamicBody, position);
		this.loadTextures();
		
		CircleShape rect = new CircleShape();
		//PolygonShape rect = new PolygonShape();
		rect.setRadius(SIZE);
		//rect.setAsBox(SIZE / 2, SIZE / 2);
		super.setShape(world, rect);
		rect.dispose();
		
		//this.bodyDef.position.set(position);
		//this.bodyDef.type = BodyType.DynamicBody;
		//this.body = world.createBody(bodyDef);
		//this.body.createFixture(rect, 0f);
		//this.body.setUserData(this);
		
	}

	public State getState() {
		return state;
	}
	
	public void setState(State newState) {
		this.state = newState;
	}
	
	public float getStateTime(){
		return stateTime;
	}

	public void setPosition(Vector2 position) {
		this.bodyDef.position.set(position);
	}
	
	public void setStateTime(float stateTime) {
		this.stateTime = stateTime;
	}
	
	public void update(float delta) {
		stateTime += delta;
		//position.add(velocity.tmp().mul(delta)); 
	}

	@Override
	protected void loadTextures() {
		bobIdleRight = WorldRenderer.atlas.findRegion("bob-01");
		bobIdleRight.flip(true, false);
		TextureRegion[] walkRightFrames = new TextureRegion[5];

		for (int i = 0; i < 5; i++) {
			walkRightFrames[i] = WorldRenderer.atlas.findRegion("bob-0" + (i + 2));
			walkRightFrames[i].flip(true, false);
		}
		
		walkRightAnimation = new Animation(RUNNING_FRAME_DURATION, walkRightFrames);
		bobJumpRight = WorldRenderer.atlas.findRegion("bob-up");
		bobJumpRight.flip(true, false);
		bobFallRight = WorldRenderer.atlas.findRegion("bob-down");
		bobFallRight.flip(true, false);
	}

	@Override
	protected void draw() {
		this.texture = bobIdleRight;
		if(this.state.equals(State.ACCELERATING)) {
			this.texture = walkRightAnimation.getKeyFrame(this.stateTime, true);
		} else if (this.state.equals(State.LIFTING)) {
			this.texture = bobJumpRight;
		} else if (this.state.equals(State.DESCENDING)) {
			this.texture = bobFallRight;
		}
	}
}