package com.gamegear.firstwing.actors;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.gamegear.firstwing.TextureMgr;
import com.gamegear.firstwing.actors.Actor;

public class Block extends Actor {

	public float SIZE = 1f;
	private TextureRegion blockTexture;
	private String textureName;
	
	public Block(Vector2 position, World world, String textureName) {
		super(1, 1f, 1f, BodyType.StaticBody, position);
		this.textureName = textureName;
		this.loadTextures();
		
		PolygonShape rect = new PolygonShape();
		rect.setAsBox(SIZE / 2, SIZE / 2);
		this.setShape(world, rect);
	}

	@Override
	protected void loadTextures() {
		blockTexture = TextureMgr.getTexture(textureName, true);
	}

	@Override
	protected void draw() {
		this.setTexture(blockTexture);
	}
}