package com.gamegear.firstwing.actors;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

public abstract class Actor {

	public float SPEED;	// unit per second
	public float SCALE;
	public float WIDTH;
	public float HEIGHT;
	
	protected Body body;
	protected BodyDef bodyDef = new BodyDef();
	protected Sprite bodySprite;
	protected TextureRegion texture;
	Shape shape;
	
	public Actor(float speed, float scale, float width, float height, BodyType bodyType, Vector2 position)
	{
		this.SPEED = speed;
		this.SCALE = scale;
		this.WIDTH = width;
		this.HEIGHT = height;
		this.bodyDef.type = bodyType;
		this.bodyDef.position.set(position);
	}
	
	public void setShape(World world, Shape shape)
	{
		this.body = world.createBody(bodyDef);
		this.body.createFixture(shape, 0f);
		this.body.setUserData(this);
	}
	
	public Body getBody(){
		return this.body;
	}
	
	public Vector2 getPosition() {
		return body.getPosition();
	}
	
	public TextureRegion getTexture(){
		this.draw();
		return texture;
	}
	
	protected abstract void loadTextures();
	
	protected abstract void draw();
	
	public float getWidth() {
		return WIDTH;
	}

	public float getHeight() {
		return HEIGHT;
	}
}
