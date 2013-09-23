package com.gamegear.firstwing.screens;

import java.util.LinkedList;
import java.util.Queue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.gamegear.firstwing.BobController;
import com.gamegear.firstwing.FwWorld;
import com.gamegear.firstwing.WorldRenderer;
import com.gamegear.firstwing.actors.Bob;
import com.gamegear.firstwing.actors.Enemy;

public class GameScreen implements Screen {

	public FwWorld 			world;
	public WorldRenderer 	renderer;
	public BobController	controller;
	public Bob				bob;
	public GestureDetector 	gestureDetector;
	public Texture 			interfaceTexture;
	public SpriteBatch 		interfaceBatch;
	public BitmapFont 		font;
	public Music			music;
	public Queue<Enemy>		enemiesForRemoval;
	
	
	InputMultiplexer im;
	
	private int width, height;
	
	@Override
	public void show() {
		
		//Rendering
		world = new FwWorld("");
		bob = world.getBob();
		renderer = new WorldRenderer(world, false);
		font = new BitmapFont();
		
		interfaceTexture = new Texture(Gdx.files.internal("images/dpad.png"));
		interfaceBatch = new SpriteBatch();
		
		//Input
		controller = new BobController(this, width, height);
		gestureDetector = new GestureDetector(20, 0.5f, 1, 0.15f, controller);
		im = new InputMultiplexer(controller, gestureDetector); // Order matters here!
		Gdx.input.setInputProcessor(im);
		
		//Contact listener
		enemiesForRemoval = new LinkedList<Enemy>();
		createCollisionListener();
		
		//Play music
		music = Gdx.audio.newMusic(Gdx.files.internal("sounds/BergsmatarenLever.ogg"));
		music.setVolume(0.1f);
		music.setLooping(true);
		music.play();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		removeEnemies();

		//Update input
		controller.update(delta);
		
		//Update Bob speed
		bob.getBody().setLinearVelocity(controller.linImpulseX + world.getLevel().getSpeed(),controller.linImpulseY);
		
		//Render frame
		renderer.render();
		
		//Render interface
		renderInterface();
		renderFPS();
		
		//Debug reset
//		if(renderer.cameraX > 14)
//		{
//			loadLevel("");
//		}
	}
	
	public void renderInterface()
	{
		if(controller.getDpadCenterX() > 0)
		{
			interfaceBatch.begin();
			interfaceBatch.draw(interfaceTexture, controller.getDpadCenterX() - interfaceTexture.getWidth()/4, controller.getDpadCenterY() - interfaceTexture.getHeight()/4, interfaceTexture.getWidth()/2, interfaceTexture.getHeight()/2);
			interfaceBatch.draw(interfaceTexture, controller.getDpadX() - interfaceTexture.getWidth()/2, controller.getDpadY() - interfaceTexture.getHeight()/2, interfaceTexture.getWidth(), interfaceTexture.getHeight());
			interfaceBatch.end();
			//Gdx.app.log("Interface", "Dpad center  x:" + controller.getDpadCenterX() + " y:" + controller.getDpadCenterY() + " current x:" + controller.getDpadX() + " y:" + controller.getDpadY());
		}
	}
	
	public void renderFPS()
	{
		interfaceBatch.begin();
		font.draw(interfaceBatch, "fps:" + Gdx.graphics.getFramesPerSecond(), 0, 20);
		interfaceBatch.end();
	}
	
	public void loadLevel(String levelPath)
	{		
		//Rendering
		world = new FwWorld(levelPath);
		bob = world.getBob();
		renderer = new WorldRenderer(world, false);
		font = new BitmapFont();

		interfaceTexture = new Texture(Gdx.files.internal("images/dpad.png"));
		interfaceBatch = new SpriteBatch();

		// Input
		controller = new BobController(this, width, height);
		gestureDetector = new GestureDetector(20, 0.5f, 1, 0.15f, controller);
		im = new InputMultiplexer(controller, gestureDetector);
		Gdx.input.setInputProcessor(im);

		// Contact listener
		createCollisionListener();
	}
	
	private void createCollisionListener() {
        world.getWorld().setContactListener(new ContactListener() {

            @Override
            public void beginContact(Contact contact) {
                Fixture fixtureA = contact.getFixtureA();
                Fixture fixtureB = contact.getFixtureB();
                Enemy collisionEnemy = null;
                
                Gdx.app.log("beginContact", "between " + fixtureA.toString() + " and " + fixtureB.toString());
                
                for(Enemy en : world.getLevel().getEnemies())
            	{
                	if(en.getBody().equals(contact.getFixtureA().getBody()))
            		{
                		collisionEnemy = en;
                		break;
            		}
            		if(en.getBody().equals(contact.getFixtureB().getBody()))
            		{
            			collisionEnemy = en;
            			break;
            		}
            	}
                
                if(contact.getFixtureA().getBody().getType() == BodyType.DynamicBody)
                {
                	renderer.callParticleSystem(contact.getFixtureA().getBody().getWorldCenter().x, contact.getFixtureA().getBody().getWorldCenter().y);
                }
                else
                {
                	renderer.callParticleSystem(contact.getFixtureB().getBody().getWorldCenter().x, contact.getFixtureB().getBody().getWorldCenter().y);
                }
                
                if(collisionEnemy != null)
                {
                	enemiesForRemoval.add(collisionEnemy);
                	//world.getWorld().destroyBody(collisionEnemy.getBody());
                    //world.getLevel().getEnemies().remove(collisionEnemy);
                }
            }

            @Override
            public void endContact(Contact contact) {
                Fixture fixtureA = contact.getFixtureA();
                Fixture fixtureB = contact.getFixtureB();
                Gdx.app.log("endContact", "between " + fixtureA.toString() + " and " + fixtureB.toString());
            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {
            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {
            }

        });
    }
	
	public void removeEnemies()
	{
		Enemy e;
		for(int i = 0; i < enemiesForRemoval.size(); i++)
		{
			e = enemiesForRemoval.poll();
			world.getWorld().destroyBody(e.getBody());
            world.getLevel().getEnemies().remove(e);
		}
		
	}
	
	@Override
	public void resize(int width, int height) {
		renderer.setSize(width, height);
		this.width = width;
		this.height = height;
		controller.width = width;
		controller.height = height;
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		Gdx.input.setInputProcessor(null);
		interfaceBatch.dispose();
		music.stop();
		music.dispose();
		Gdx.app.exit();
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
	}

	@Override
	public void dispose() {
		Gdx.input.setInputProcessor(null);
		interfaceBatch.dispose();
		music.stop();
		music.dispose();
		Gdx.app.exit();
	}
}