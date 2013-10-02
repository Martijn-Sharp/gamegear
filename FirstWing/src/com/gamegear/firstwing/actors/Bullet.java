package com.gamegear.firstwing.actors;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.World;
import com.gamegear.firstwing.TextureMgr;
import com.gamegear.firstwing.actors.json.DynamicActor;
import com.gamegear.firstwing.levels.json.LevelProperties.ColorEnum;

public class Bullet extends MoveableActor {
	private static final float SPEED = 4f;
	private static final float SCALE = 1f;
	private static final float WIDTH = 0.25f;
	private static final float HEIGHT = 0.25f;
	
	private ColorEnum color;

	private TextureRegion bullet;
	//private TextureRegion bulletDebug;

	public Bullet(Vector2 position, World world, Filter filter, ColorEnum color) {
		super(new DynamicActor(SPEED, 0f, "bullet", SCALE, WIDTH, HEIGHT, null), position, world, filter);
		this.color = color;
		this.loadTextures();
		CircleShape rect = new CircleShape();
		rect.setRadius((HEIGHT + WIDTH) / 4);
		this.setShape(rect, 0.1f);
	}
	
	public ColorEnum getColor(){
		return this.color;
	}

	@Override
	protected void loadTextures() {
		switch(color)
		{
			case red:		bullet = TextureMgr.getTexture("red-bullet-glow", false); break;
			case yellow:	bullet = TextureMgr.getTexture("yellow-bullet-glow", false); break;
			case purple:	bullet = TextureMgr.getTexture("purple-bullet-glow", false); break;
			case orange:	bullet = TextureMgr.getTexture("orange-bullet-glow", false); break;
			case green:		bullet = TextureMgr.getTexture("green-bullet-glow", false); break;
			case lightblue:	bullet = TextureMgr.getTexture("lightblue-bullet-glow", false); break;
			case blue:		bullet = TextureMgr.getTexture("blue-bullet-glow", false); break;
			case none:		bullet = TextureMgr.getTexture("red-bullet-glow", false); break;
			default:		bullet = TextureMgr.getTexture("red-bullet-glow", false); break;
		}
	}

	@Override
	protected void draw() {
		this.setTexture(bullet);
	}
}
