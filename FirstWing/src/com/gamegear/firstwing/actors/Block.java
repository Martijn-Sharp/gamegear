package com.gamegear.firstwing.actors;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.gamegear.firstwing.WorldRenderer;
import com.gamegear.firstwing.actors.Actor;

public class Block extends Actor {

	public float SIZE = 1f;
	private TextureRegion blockTexture;
	
	public Block(Vector2 pos, World world) {
		super.SIZE = SIZE;
		this.loadTextures();
		this.bodyDef.position.set(pos);
		this.bodyDef.type = BodyType.StaticBody;
		this.body = world.createBody(this.bodyDef);
		
		PolygonShape rect = new PolygonShape();
		rect.setAsBox(SIZE / 2, SIZE / 2);
		this.body.createFixture(rect, 0.0f);
		this.body.setUserData(this);
		rect.dispose();
	}

	@Override
	protected void loadTextures() {
		blockTexture = WorldRenderer.atlas.findRegion("block");
	}

	@Override
	protected void draw() {
		this.texture = blockTexture;
	}
}