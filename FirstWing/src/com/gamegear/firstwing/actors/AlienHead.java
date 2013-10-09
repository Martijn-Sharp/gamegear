package com.gamegear.firstwing.actors;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.gamegear.firstwing.TextureMgr;
import com.gamegear.firstwing.actors.json.StaticActor;

public class AlienHead extends Actor {
	private TextureRegion alienHeadTexture;

	public AlienHead(Vector2 position, World world, StaticActor actor, Filter filter) {
		super(actor, BodyType.StaticBody, position, world, filter);
		this.loadTextures();
		this.setShape(this.createShape(actor, false), 0f);
	}
	@Override
	protected void loadTextures() {
		this.alienHeadTexture = TextureMgr.getTexture("alienhead", true);
	}

	@Override
	protected void draw() {
		if(this.getState() == ActorState.DYING){
			this.setState(ActorState.DEAD, false);
		} else {
			this.setTexture(this.alienHeadTexture);
		}
	}
}
