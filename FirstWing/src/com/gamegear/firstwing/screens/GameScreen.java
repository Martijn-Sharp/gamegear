package com.gamegear.firstwing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.utils.Array;
import com.gamegear.firstwing.BobController;
import com.gamegear.firstwing.FwWorld;
import com.gamegear.firstwing.WorldRenderer;
import com.gamegear.firstwing.actors.Bob;
import com.gamegear.firstwing.actors.Bullet;
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
	public Array<Enemy>		enemiesForRemoval;
	
	// Bullets
	private Array<Bullet> 	bullets;
	public Array<Bullet>	bulletsForRemoval;
	long					timeSinceLastBullet;
	
	
	InputMultiplexer im;
	
	private int width, height;
	
	@Override
	public void show() {
		
		//Bullet array
		bullets = new Array<Bullet>();
		bulletsForRemoval = new Array<Bullet>();
		
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
		createCollisionListener();
		enemiesForRemoval = new Array<Enemy>();
		
		
		//Play music
		music = Gdx.audio.newMusic(Gdx.files.internal("sounds/BergsmatarenLever.ogg"));
		music.setVolume(0.1f);
		music.setLooping(true);
		//music.play();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		removeBodies();
		
		//Update input
		controller.update(delta);
		
		//Update Bob speed
		bob.getBody().setLinearVelocity(controller.linImpulseX + world.getLevel().getSpeed(),controller.linImpulseY);
		
		//Update bullets
		checkBulletFire();
		
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
		//Bullet array
		bullets = new Array<Bullet>();
		
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
	
	public void checkBulletFire()
	{
		int maxBullets = 10;
		
		//Maximum bullets on screen
        if(bullets.size > maxBullets)
        {
        	bulletsForRemoval.add(bullets.get(0));
        	//bullets.removeIndex(0);
        }
        
        //Remove bullets off screen
        for(Bullet b : bullets)
        {
        	if(b.getBody().getWorldCenter().x > renderer.cameraX + 6)
        	{
        		bulletsForRemoval.add(b);
        	}
        }
		
		//Bullet delay in seconds
		float bulletDelay = 0.5f;
		float elapsedTime=(System.nanoTime()-timeSinceLastBullet)/1000000000.0f;
        if(elapsedTime>bulletDelay){
        	timeSinceLastBullet = System.nanoTime();
        	Bullet temp = new Bullet(bob.getBody().getWorldPoint(new Vector2(0.8f,0)), world.getWorld());
        	temp.getBody().setBullet(true);
        	temp.getBody().setLinearVelocity(10,0);
        	bullets.add(temp);
        }
	}
	
	private void createCollisionListener() {
        world.getWorld().setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {
                Fixture fixtureA = contact.getFixtureA();
                Fixture fixtureB = contact.getFixtureB();
                Enemy collisionEnemy = null;
                Bullet collisionBullet = null;
                
                //Gdx.app.log("beginContact", "between " + fixtureA.toString() + " and " + fixtureB.toString());
                
                for(Enemy en : world.getLevel().getEnemies())
            	{
                	if(en.getBody().equals(fixtureA.getBody()))
            		{
                		collisionEnemy = en;
                		break;
            		}
            		if(en.getBody().equals(fixtureB.getBody()))
            		{
            			collisionEnemy = en;
            			break;
            		}
            	}
                
                for(Bullet b : bullets)
            	{
                	if(b.getBody().equals(fixtureA.getBody()))
                	{
                		collisionBullet = b;
                		break;
                	}
                	else if(b.getBody().equals(fixtureB.getBody()))
                	{
                		collisionBullet = b;
                		break;
                	}
            	}
                
//                if(fixtureA.getBody().getType() == BodyType.DynamicBody && !fixtureA.getBody().isBullet())
//                {
//                	if(fixtureB.getBody().isBullet() && collisionEnemy != null)
//                	{
//                		collisionEnemy.setHealth(collisionEnemy.getHealth() - 5);
//                		renderer.callParticleSystem(contact.getFixtureA().getBody().getWorldCenter().x, contact.getFixtureA().getBody().getWorldCenter().y);
//                	}
//                	if(fixtureA.getBody().equals(bob.getBody()))
//                	{
//                		renderer.callParticleSystem(contact.getFixtureA().getBody().getWorldCenter().x, contact.getFixtureA().getBody().getWorldCenter().y);
//                	}
//                }
//                else if (fixtureB.getBody().getType() == BodyType.DynamicBody && !fixtureB.getBody().isBullet())
//                {
//                	if(fixtureA.getBody().isBullet()  && collisionEnemy != null)
//                	{
//                		collisionEnemy.setHealth(collisionEnemy.getHealth() - 5);
//                		renderer.callParticleSystem(contact.getFixtureB().getBody().getWorldCenter().x, contact.getFixtureB().getBody().getWorldCenter().y);
//                	}
//                	if(fixtureB.getBody().equals(bob.getBody()))
//                	{
//                		renderer.callParticleSystem(contact.getFixtureB().getBody().getWorldCenter().x, contact.getFixtureB().getBody().getWorldCenter().y);
//                	}
//                }
                if(!doDamageEnemy(fixtureA, fixtureB,collisionEnemy))
                {
                	doDamageEnemy(fixtureB, fixtureA, collisionEnemy);
                }
                
                if(collisionEnemy != null)
                {
                	if(collisionEnemy.getHealth() <= 0)
                	{
                		if(!enemiesForRemoval.contains(collisionEnemy, true))
                    	{
                			enemiesForRemoval.add(collisionEnemy);
                    	}
                	}
                	//world.getWorld().destroyBody(collisionEnemy.getBody());
                    //world.getLevel().getEnemies().remove(collisionEnemy);
                }
                if(collisionBullet != null)
                {
                	if(!bulletsForRemoval.contains(collisionBullet, true))
                	{
                		bulletsForRemoval.add(collisionBullet);
                	}
                }
            }

            @Override
            public void endContact(Contact contact) {
                //Fixture fixtureA = contact.getFixtureA();
                //Fixture fixtureB = contact.getFixtureB();
                //Gdx.app.log("endContact", "between " + fixtureA.toString() + " and " + fixtureB.toString());
            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {
            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {
            }

        });
    }
	
	public boolean doDamageEnemy(Fixture a, Fixture b, Enemy enemy)
	{
		if(a.getBody().getType() == BodyType.DynamicBody && enemy != null)
        {
			if(a.getBody().equals(bob.getBody()))
        	{
        		renderer.callParticleSystem(a.getBody().getWorldCenter().x, a.getBody().getWorldCenter().y);
        		return true;
        	}
			else if(a.getBody().equals(enemy.getBody()))
			{
				enemy.setHealth(enemy.getHealth() - 5);
        		renderer.callParticleSystem(a.getBody().getWorldCenter().x, a.getBody().getWorldCenter().y);
        		return true;
			}
        }
		return false;
	}
	
	public void removeBodies()
	{
		if(!world.getWorld().isLocked())
		{
			Enemy e;
			for(int i = 0; i < enemiesForRemoval.size; i++)
			{
				e = enemiesForRemoval.pop();
				world.getLevel().getEnemies().remove(e);
				world.getWorld().destroyBody(e.getBody());
			}
		
			Bullet b;
			for(int i = 0; i < bulletsForRemoval.size; i++)
			{
				b = bulletsForRemoval.pop();
				bullets.removeValue(b, true);
				world.getWorld().destroyBody(b.getBody());
			}
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