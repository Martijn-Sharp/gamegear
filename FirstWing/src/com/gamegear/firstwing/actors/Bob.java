package com.gamegear.firstwing.actors;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.gamegear.firstwing.TextureMgr;

public class Bob extends MoveableActor {
	private static final float SPEED = 4f;
	private static final float SCALE = 1f;
	private static final float WIDTH = 1f;
	private static final float HEIGHT = 1f;
	private static final float RUNNING_FRAME_DURATION = 0.06f;

	private TextureRegion bobIdleRight;
	private TextureRegion bobJumpRight;
	private TextureRegion bobFallRight;
	
	private TextureRegion bobShipRight;
	
	private Animation walkRightAnimation;

	public Bob(Vector2 position, World world) {
		super(SPEED, SCALE, WIDTH, HEIGHT, position, world);
		this.loadTextures();
		
		PolygonShape rect = new PolygonShape();
		Vector2[] polygons = new Vector2[5];
		polygons[0] = new Vector2(0.5f, 0f);
		polygons[1] = new Vector2(0.2f,0.2f);
		polygons[2] = new Vector2(-0.4f,0.3f);
		polygons[3] = new Vector2(-0.4f,-0.3f);
		polygons[4] = new Vector2(0.2f,-0.2f);
		rect.set(polygons);
		this.setShape(rect, 0f);
	}

	@Override
	protected void loadTextures() {
//		bobIdleRight = TextureMgr.getTexture("bob-01", false);
		bobShipRight = TextureMgr.getTexture("bobSpaceship", false);
		//bobIdleRight.flip(true, false);
//		TextureRegion[] walkRightFrames = new TextureRegion[5];
//
//		for (int i = 0; i < 5; i++) {
//			walkRightFrames[i] = TextureMgr.getTexture("bob-0" + (i + 2), false);
//			walkRightFrames[i].flip(true, false);
//		}
		
//		walkRightAnimation = new Animation(RUNNING_FRAME_DURATION, walkRightFrames);
//		bobJumpRight = TextureMgr.getTexture("bob-up", false);
//		bobJumpRight.flip(true, false);
//		bobFallRight = TextureMgr.getTexture("bob-down", false);
//		bobFallRight.flip(true, false);
	}

	@Override
	protected void draw() {
		this.setTexture(bobShipRight);
		if(this.getState().equals(State.ACCELERATING)) {
			this.setTexture(walkRightAnimation.getKeyFrame(this.getStateTime(), true));
		} else if (this.getState().equals(State.LIFTING)) {
			this.setTexture(bobJumpRight);
		} else if (this.getState().equals(State.DESCENDING)) {
			this.setTexture(bobFallRight);
		}
	}
}