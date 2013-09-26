package com.gamegear.firstwing.actors;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.gamegear.firstwing.TextureMgr;
import com.gamegear.firstwing.actors.json.StaticActor;
import com.gamegear.firstwing.levels.json.LevelProperties.ColorEnum;

public class Orb extends Actor {
	private TextureRegion orbTexture;
	private ColorEnum color;
	private final static int POINTS = 10;

	public Orb(Vector2 position, World world, StaticActor actor, ColorEnum color) {
		super(actor.Scale, actor.Width, actor.Height, BodyType.StaticBody, position, world);
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
		this.orbTexture = TextureMgr.getTexture("orb", true);
	}

	@Override
	protected void draw() {
		this.setTexture(this.orbTexture);
	}
}