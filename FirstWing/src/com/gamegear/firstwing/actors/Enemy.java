package com.gamegear.firstwing.actors;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.World;
import com.gamegear.firstwing.TextureMgr;
import com.gamegear.firstwing.actors.json.DynamicActor;
import com.gamegear.firstwing.levels.json.LevelProperties.ColorEnum;

public class Enemy extends MoveableActor {
	private float health;
	private String type;
	private TextureRegion drone;
	private Animation deathAnimation;
	private ColorEnum color;
	private World world;
	
	public Enemy(Vector2 position, World world, DynamicActor actor, String type, Filter filter, float speed){
		super(actor, position, world, filter);
		this.health = actor.Health;
		this.type = type;
		this.color = ColorEnum.valueOf(this.type.split("-")[1]);
		this.world = world;
		this.loadTextures();
		this.setShape(this.createShape(actor, false), 2f);
		this.setSpeed(speed);
	}
	
	@Override
	protected void loadTextures() {
		this.drone = TextureMgr.getTexture(this.type, false);
		TextureRegion[] deathFrames = new TextureRegion[6];
		for(int i = 0; i < 6; i++){
			deathFrames[i] = TextureMgr.getTexture(this.type + "-death" + i, false);
		}
		
		this.deathAnimation = new Animation(0.1f, deathFrames);
	}

	@Override
	protected void draw() {
		if(this.getState() == ActorState.DYING){
			this.setTexture(this.deathAnimation.getKeyFrame(this.stateTime, false));
			if(this.deathAnimation.isAnimationFinished(this.stateTime)){
				this.setState(ActorState.DEAD, false);
			}
		} else {
			this.setTexture(this.drone);
		}
	}

	public float getHealth() {
		return health;
	}
	
	public void setHealth(float health) {
		this.health = health;
	}
	
	public ColorEnum getColor(){
		return this.color;
	}
	
	public World getWorld(){
		return this.world;
	}
}
