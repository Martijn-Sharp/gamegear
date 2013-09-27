package com.gamegear.firstwing.actors;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.World;
import com.gamegear.firstwing.TextureMgr;
import com.gamegear.firstwing.levels.json.LevelProperties.ColorEnum;

public class Bullet extends MoveableActor {
	private static final float SPEED = 4f;
	private static final float SCALE = 1f;
	private static final float WIDTH = 0.25f;
	private static final float HEIGHT = 0.25f;
	
	private ColorEnum color;

	private TextureRegion bulletYellow;
	private TextureRegion bulletRed;
	private TextureRegion bulletPurple;
	private TextureRegion bulletOrange;
	private TextureRegion bulletGreen;
	private TextureRegion bulletLightBlue;
	private TextureRegion bulletBlue;
	private TextureRegion bulletNone;
	//private TextureRegion bulletDebug;

	public Bullet(Vector2 position, World world, Filter filter, ColorEnum color) {
		super(SPEED, SCALE, WIDTH, HEIGHT, position, world, filter);
		this.color = color;
		this.loadTextures();
		CircleShape rect = new CircleShape();
		rect.setRadius((HEIGHT + WIDTH) / 4);
		this.setShape(rect, 0.1f);
	}

	@Override
	protected void loadTextures() {
		switch(color)
		{
			case red:		bulletRed = TextureMgr.getTexture("red-bullet-glow", false); break;
			case yellow:	bulletYellow = TextureMgr.getTexture("yellow-bullet-glow", false); break;
			case purple:	bulletPurple = TextureMgr.getTexture("purple-bullet-glow", false); break;
			case orange:	bulletOrange = TextureMgr.getTexture("orange-bullet-glow", false); break;
			case green:		bulletGreen = TextureMgr.getTexture("green-bullet-glow", false); break;
			case lightblue:	bulletLightBlue = TextureMgr.getTexture("lightblue-bullet-glow", false); break;
			case blue:		bulletBlue = TextureMgr.getTexture("blue-bullet-glow", false); break;
			case none:		bulletNone = TextureMgr.getTexture("red-bullet-glow", false); break;
			default:		bulletNone = TextureMgr.getTexture("red-bullet-glow", false); break;
		}
	}

	@Override
	protected void draw() {
		
		if(color.equals(ColorEnum.green)) {
			this.setTexture(bulletGreen);
		} 
		else if (color.equals(ColorEnum.blue)) {
			this.setTexture(bulletBlue);
		}
		else if(color.equals(ColorEnum.lightblue))
		{
			this.setTexture(bulletLightBlue);
		}
		else if(color.equals(ColorEnum.orange))
		{
			this.setTexture(bulletOrange);
		}
		else if(color.equals(ColorEnum.purple))
		{
			this.setTexture(bulletPurple);
		}
		else if(color.equals(ColorEnum.red))
		{
			this.setTexture(bulletRed);
		}
		else if(color.equals(ColorEnum.yellow))
		{
			this.setTexture(bulletYellow);
		}
		else if(color.equals(ColorEnum.none))
		{
			this.setTexture(bulletNone);
		}
		else
		{
			this.setTexture(bulletRed);
		}
	}
}
