package com.gamegear.firstwing.actors;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.gamegear.firstwing.TextureMgr;
import com.gamegear.firstwing.actors.Actor;
import com.gamegear.firstwing.actors.json.StaticActor;

public class Block extends Actor {

	public float SIZE = 1f;
	private TextureRegion blockTexture;
	private String textureName;
	
	public Block(Vector2 position, World world, StaticActor actor) {
		super(actor.Scale, actor.Width, actor.Height, BodyType.StaticBody, position, world);
		this.textureName = actor.Name;
		this.loadTextures();
		this.setShape(this.createShape(actor, true), 0f);
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