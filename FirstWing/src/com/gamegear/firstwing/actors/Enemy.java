package com.gamegear.firstwing.actors;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.World;
import com.gamegear.firstwing.TextureMgr;
import com.gamegear.firstwing.actors.json.DynamicActor;

public class Enemy extends MoveableActor {
	private static final float SPEED = 4f;
	private static final float SCALE = 1f;
	private static final float WIDTH = 0.25f;
	private static final float HEIGHT = 0.25f;
	
	private float health = 10f;

	private TextureRegion droneBlue;
	private TextureRegion droneGreen;
	private TextureRegion droneYellow;
	private TextureRegion droneOrange;
	
	private TextureRegion bobShipRight;
	
	public Enemy(Vector2 position, World world, DynamicActor actor){
		super(actor.Speed, actor.Scale, actor.Width, actor.Height, position);
		this.loadTextures();
		
		CircleShape rect = new CircleShape();
		rect.setRadius(0.5f / 2);
		this.setShape(world, rect, 2f);
	}
	
	@Override
	protected void loadTextures() {
		//this.idleLeft = TextureMgr.getTexture("bob-01", false);
		this.droneYellow = TextureMgr.getTexture("drone-yellow", false);
		//this.droneBlue = TextureMgr.getTexture("drone-blue", false);
		//bobShipRight = TextureMgr.getTexture("bobSpaceship", false);
	}

	@Override
	protected void draw() {
		this.setTexture(this.droneYellow);
		//this.setTexture(bobShipRight);
	}

	public float getHealth() {
		return health;
	}
	
	public void setHealth(float health) {
		this.health = health;
	}
}
