package com.gamegear.firstwing;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.utils.Array;
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
	
	ParticleEffect effect;
	int emitterIndex;
	Array<ParticleEmitter> emitters;
	int particleCount = 10;

	
	float cameraX = 0;
	float cameraY = 0;

	
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
		this.cameraX = CAMERA_WIDTH / 2f;
		this.cameraY = CAMERA_HEIGHT / 2f;
		this.cam.position.set(this.cameraX, this.cameraY, 0);
		this.cam.update();
		this.debug = debug;
		spriteBatch = new SpriteBatch();
		this.debugRenderer = new Box2DDebugRenderer();
		
		//Particle effect
		effect = new ParticleEffect();
		effect.load(Gdx.files.internal("effects/explosion.p"), Gdx.files.internal("effects"));
		effect.setPosition(world.getBob().getBody().getWorldCenter().x, world.getBob().getBody().getWorldCenter().y);
		
//		float pScale = 1f;
//
//	    float scaling = effect.getEmitters().get(0).getScale().getHighMax();
//	    effect.getEmitters().get(0).getScale().setHigh(scaling * pScale);
//
//	    scaling = effect.getEmitters().get(0).getScale().getLowMax();
//	    effect.getEmitters().get(0).getScale().setLow(scaling * pScale);
//
//	    scaling = effect.getEmitters().get(0).getVelocity().getHighMax();
//	    effect.getEmitters().get(0).getVelocity().setHigh(scaling * pScale);
//
//	    scaling = effect.getEmitters().get(0).getVelocity().getLowMax();
//	    effect.getEmitters().get(0).getVelocity().setLow(scaling * pScale);
		
		
		// Of course, a ParticleEffect is normally just used, without messing around with its emitters.
		//emitters = new Array<ParticleEmitter>(effect.getEmitters());
		//effect.getEmitters().clear();
		//effect.getEmitters().add(emitters.get(0));
		
		//callParticleSystem();
	}
	
	public void callParticleSystem()
	{
		effect.reset();
		effect.setPosition(world.getBob().getBody().getWorldCenter().x, world.getBob().getBody().getWorldCenter().y);
		effect.start();
		System.out.println("Effect restarting");
	}
	
	public void render() {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		moveCamera(world.getBob().getBody().getWorldCenter().x, world.getBob().getBody().getWorldCenter().y, world.level.getSpeed(cameraX));
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
		effect.setPosition(world.getBob().getBody().getWorldCenter().x, world.getBob().getBody().getWorldCenter().y);
		effect.draw(spriteBatch, Gdx.graphics.getDeltaTime());
		spriteBatch.end();
		
		world.world.step(Gdx.app.getGraphics().getDeltaTime(), 3, 3);
		
		if(effect.isComplete())
		{
			callParticleSystem();
		}
//		debugRenderer.render(world.world, cam.combined);
//		world.world.step(1/60f, 6, 2);
	}
	
	public void draw(SpriteBatch batch, float parentAlpha){ //what this method is called may differ depending on what 
		//system you're using; I am using stage/actor
		effect.draw(batch);
	}
	
	public void moveCamera(float x,float y, float speed){	
		//Cap camera at the top and bottom
		if(y + 4 > 10){cameraY = 6f;}
		else if(y - 3 < 0) {cameraY = 3;}
		else{cameraY = y;}
		
		//Cap camera at the sides
//		if(x + 5 > world.level.getWidth()){cameraX = world.level.getWidth() - 5;}
//		else if(x - 5 < 0) {cameraX = 5;}
//		else{cameraX = x;}
		
		//Move camera with speed
		cameraX += Gdx.graphics.getDeltaTime() * speed;		
		
		//Gdx.app.log("Camera", "X:" + cameraX + "," + x + " Y:" + cameraY + "," + y);
		
		
        cam.position.set(cameraX, cameraY, 0);
        cam.update();
	}
	public OrthographicCamera getCam() {
		return cam;
	}
}