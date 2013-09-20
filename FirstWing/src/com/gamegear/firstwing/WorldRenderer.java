package com.gamegear.firstwing;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.gamegear.firstwing.actors.Actor;

public class WorldRenderer {
	private static final float CAMERA_WIDTH = 10f;
	private static final float CAMERA_HEIGHT = 7f;
	
	private FwWorld world;
	private OrthographicCamera cam;

	/** for debug rendering **/
	private Box2DDebugRenderer debugRenderer;

	/** Textures **/
	public static TextureAtlas atlas = new TextureAtlas(Gdx.files.internal("textures/textures.pack"));
	private SpriteBatch spriteBatch;
	private boolean debug = false;
	@SuppressWarnings("unused")
	private int width;
	@SuppressWarnings("unused")
	private int height;
	private Iterator<Body> tmpBodies;
	
	public void setSize (int w, int h) {
		this.width = w;
		this.height = h;
	}
	public boolean isDebug() {
		return debug;
	}
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public WorldRenderer(FwWorld world, boolean debug) {
		this.world = world;
		this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		this.cam.setToOrtho(false, CAMERA_WIDTH, CAMERA_HEIGHT);
		this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
		this.cam.update();
		this.debug = debug;
		spriteBatch = new SpriteBatch();
		this.debugRenderer = new Box2DDebugRenderer();
	}
	
	public void render() {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		moveCamera(world.getBob().getPosition().x, world.getBob().getPosition().y);
		spriteBatch.setProjectionMatrix(cam.combined);
		spriteBatch.begin();
			tmpBodies = world.world.getBodies();
			Body node;
			while(tmpBodies.hasNext()){
				node = tmpBodies.next();
				
				if(node.getUserData() != null && node.getUserData() instanceof Actor)
				{
					Actor actor = (Actor) node.getUserData();
					//spriteBatch.draw(actor.getTexture(), actor.getBody().getPosition().x - actor.SIZE / 2, actor.getBody().getPosition().y - actor.SIZE / 2, actor.SIZE, actor.SIZE);
					//, actor.getPosition().angle(), false
					float rotationAngle = actor.getBody().getAngle() * MathUtils.radiansToDegrees - 90;
					Vector2 position = actor.getBody().getPosition();
					float width = actor.getWidth();
					float height = actor.getHeight();
					float scale = actor.getScale();
					
					spriteBatch.draw(
							actor.getTexture(), 
							position.x - width /2, 
							position.y - height /2,
							width /2, 
							height /2, 
							width, 
							height, 
							scale, 
							scale, 
							rotationAngle, 
							false);
					//batch.draw(region, 0, 0, textureWidth / 2f, textureHeight / 2f, textureWidth, textureHeight, 1, 1, rotationAngle, false);
				}
			}
		spriteBatch.end();
		
		debugRenderer.render(world.world, cam.combined);
		world.world.step(1/60f, 6, 2);
	}
	
	public void moveCamera(float x,float y){
        cam.position.set(x, y, 0);
        cam.update();
	}
	public OrthographicCamera getCam() {
		return cam;
	}
}