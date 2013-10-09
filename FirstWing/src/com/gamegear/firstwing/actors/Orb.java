package com.gamegear.firstwing.actors;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.gamegear.firstwing.TextureMgr;
import com.gamegear.firstwing.actors.json.StaticActor;
import com.gamegear.firstwing.levels.json.LevelProperties.ColorEnum;

public class Orb extends Actor {
	private TextureRegion orbTexture;
	private ColorEnum color;
	private final static int POINTS = 10;

	public Orb(Vector2 position, World world, StaticActor actor, ColorEnum color, Filter filter) {
		super(actor, BodyType.StaticBody, position, world, filter);
		this.color = color;
		this.loadTextures();
		this.setShape(this.createShape(actor, false), 0f);
	}
	
	public ColorEnum getColor(){
		return this.color;
	}
	
	public int getPoints(){
		return POINTS;
	}

	@Override
	protected void loadTextures() {
		this.orbTexture = TextureMgr.getTexture("orb-" + this.color.toString(), true);
	}

	@Override
	protected void draw() {
		if(this.getState() == ActorState.DYING){
			this.setState(ActorState.DEAD, false);
		} else {
			this.setTexture(this.orbTexture);
		}
	}
}