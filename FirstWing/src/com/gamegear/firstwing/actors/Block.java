package com.gamegear.firstwing.actors;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.gamegear.firstwing.TextureMgr;
import com.gamegear.firstwing.actors.Actor;
import com.gamegear.firstwing.actors.json.StaticActor;
import com.gamegear.firstwing.levels.json.LevelProperties.ColorEnum;
import com.gamegear.firstwing.levels.json.Tile;

public class Block extends Actor {

	public float SIZE = 1f;
	private TextureRegion blockTexture;
	private Tile tile;
	private float health;
	private ColorEnum blockColor;
	
	public Block(Vector2 position, World world, StaticActor actor, Tile tile, Filter filter, ColorEnum color) {
		super(actor, BodyType.StaticBody, position, world, filter);
		this.tile = tile;
		this.health = tile.Health;
		this.blockColor = color;
		this.loadTextures();
		this.setShape(this.createShape(actor, true), 0f);
	}
	
	public float getHealth(){
		return this.health;
	}
	
	public void setHealth(float health, ColorEnum color){
		if(this.tile.AssignedColor == color){
			this.health = health;
		}
	}
	
	public boolean isBreakable(){
		return ((StaticActor)this.getProperties()).Breakable;
	}

	@Override
	protected void loadTextures() {
		switch(((StaticActor)this.getProperties()).Type){
		case Breakable:
			blockTexture = TextureMgr.getTexture(tile.Name + "-" + tile.AssignedColor.toString(), true);
			break;
		case Tile:
			blockTexture = TextureMgr.getTexture(tile.Name + "-" + this.blockColor.toString(), true);
			break;
		case Collectable:
		case Finish:
			blockTexture = TextureMgr.getTexture(tile.Name, true);
			break;
		default:
			break;
		}
	}

	@Override
	protected void draw() {
		this.setTexture(blockTexture);
	}
}