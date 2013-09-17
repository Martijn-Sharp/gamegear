package com.gamegear.firstwing.actors;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

public abstract class Actor {
	private Body body;
	private BodyDef bodyDef;
	private TextureRegion texture;
	
	private float scale;
	private float width;
	private float height;
	
	/** @param Scale
	 * @param Width
	 * @param Height
	 * @param BodyType
	 * @param Position */
	public Actor(float scale, float width, float height, BodyType bodyType, Vector2 position)
	{
		this.scale = scale;
		this.width = width;
		this.height = height;
		this.bodyDef = new BodyDef();
		this.bodyDef.type = bodyType;
		this.bodyDef.position.set(position);
	}
	
	public void setShape(World world, Shape shape)
	{
		this.body = world.createBody(bodyDef);
		this.body.createFixture(shape, 0f);
		this.body.setUserData(this);
		shape.dispose();
	}
	
	public Body getBody(){
		return this.body;
	}
	
	public BodyDef getBodyDef(){
		return this.bodyDef;
	}
	
	public Vector2 getPosition() {
		return this.body.getPosition();
	}
	
	public float getScale() {
		return this.scale;
	}
	
	public float getWidth() {
		return this.width;
	}

	public float getHeight() {
		return this.height;
	}
	
	public TextureRegion getTexture(){
		this.draw();
		return this.texture;
	}
	
	public void setTexture(TextureRegion texture){
		this.texture = texture;
	}
	
	protected abstract void loadTextures();
	
	protected abstract void draw();
}
