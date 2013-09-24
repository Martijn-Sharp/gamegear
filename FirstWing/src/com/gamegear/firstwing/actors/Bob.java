package com.gamegear.firstwing.actors;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.World;
import com.gamegear.firstwing.TextureMgr;

public class Bob extends MoveableActor {
	private static final float SPEED = 4f;
	private static final float SCALE = 1f;
	private static final float WIDTH = 0.5f;
	private static final float HEIGHT = 0.5f;
	private static final float RUNNING_FRAME_DURATION = 0.06f;

	private TextureRegion bobIdleRight;
	private TextureRegion bobJumpRight;
	private TextureRegion bobFallRight;
	
	private Animation walkRightAnimation;

	public Bob(Vector2 position, World world) {
		super(SPEED, SCALE, WIDTH, HEIGHT, position);
		this.loadTextures();
		
		CircleShape rect = new CircleShape();
		rect.setRadius((HEIGHT + WIDTH) / 4);
		this.setShape(world, rect, 0f);
	}

	@Override
	protected void loadTextures() {
		bobIdleRight = TextureMgr.getTexture("bob-01", false);
		//bobIdleRight.flip(true, false);
		TextureRegion[] walkRightFrames = new TextureRegion[5];

		for (int i = 0; i < 5; i++) {
			walkRightFrames[i] = TextureMgr.getTexture("bob-0" + (i + 2), false);
			walkRightFrames[i].flip(true, false);
		}
		
		walkRightAnimation = new Animation(RUNNING_FRAME_DURATION, walkRightFrames);
		bobJumpRight = TextureMgr.getTexture("bob-up", false);
		bobJumpRight.flip(true, false);
		bobFallRight = TextureMgr.getTexture("bob-down", false);
		bobFallRight.flip(true, false);
	}

	@Override
	protected void draw() {
		this.setTexture(bobIdleRight);
		if(this.getState().equals(State.ACCELERATING)) {
			this.setTexture(walkRightAnimation.getKeyFrame(this.getStateTime(), true));
		} else if (this.getState().equals(State.LIFTING)) {
			this.setTexture(bobJumpRight);
		} else if (this.getState().equals(State.DESCENDING)) {
			this.setTexture(bobFallRight);
		}
	}
}