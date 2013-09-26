package com.gamegear.firstwing.actors;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.World;
import com.gamegear.firstwing.TextureMgr;

public class Bullet extends MoveableActor {
	private static final float SPEED = 4f;
	private static final float SCALE = 1f;
	private static final float WIDTH = 0.25f;
	private static final float HEIGHT = 0.25f;

	private TextureRegion bulletYellow;
	private TextureRegion bulletRed;
	private TextureRegion bulletPurple;
	//private TextureRegion bulletDebug;
	
	private boolean hit = false;

	public Bullet(Vector2 position, World world) {
		super(SPEED, SCALE, WIDTH, HEIGHT, position, world);
		this.loadTextures();
		
		CircleShape rect = new CircleShape();
		rect.setRadius((HEIGHT + WIDTH) / 4);
		this.setShape(rect, 0.1f);
	}

	@Override
	protected void loadTextures() {
		//bulletYellow = TextureMgr.getTexture("bullet-yellow", false);
		bulletRed = TextureMgr.getTexture("red-bullet", false);
		//bulletTexture = TextureMgr.getTexture("bob-up", false);
	}

	@Override
	protected void draw() {
		
		if(this.getState().equals(State.RED)) {
			this.setTexture(bulletRed);
		} 
		else if (this.getState().equals(State.PURPLE)) {
			this.setTexture(bulletPurple);
		}
		else if(this.getState().equals(State.YELLOW))
		{
			this.setTexture(bulletYellow);
		}
		else
		{
			this.setTexture(bulletRed);
		}
	}
	
	public void setHit(boolean hit)
	{
		this.hit = hit;
	}
	
	public boolean getHit()
	{
		return hit;
	}
}
