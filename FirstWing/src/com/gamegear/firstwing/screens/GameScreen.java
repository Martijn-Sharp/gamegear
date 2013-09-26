package com.gamegear.firstwing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.utils.Array;
import com.gamegear.firstwing.ActorMgr;
import com.gamegear.firstwing.BobController;
import com.gamegear.firstwing.FwWorld;
import com.gamegear.firstwing.WorldRenderer;
import com.gamegear.firstwing.actors.*;
import com.gamegear.firstwing.actors.json.StaticActor;

public class GameScreen implements Screen {

	public FwWorld 			world;
	public WorldRenderer 	renderer;
	public BobController	controller;
	public GestureDetector 	gestureDetector;
	public Texture 			interfaceTexture;
	public SpriteBatch 		interfaceBatch;
	public ShapeRenderer 	interfaceRenderer;
	public BitmapFont 		font;
	public Music			music;
	public Array<Enemy>		enemiesForRemoval;
	public Array<Orb>		orbForRemoval;
	public long				score;
	public Filter			filter = new Filter();
	
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
		renderer = new WorldRenderer(world, false);
		font = new BitmapFont();
		
		interfaceTexture = new Texture(Gdx.files.internal("images/dpad.png"));
		interfaceBatch = new SpriteBatch();
		interfaceRenderer = new ShapeRenderer();
		
		//Input
		controller = new BobController(this, width, height);
		gestureDetector = new GestureDetector(20, 0.5f, 1, 0.15f, controller);
		im = new InputMultiplexer(controller, gestureDetector); // Order matters here!
		Gdx.input.setInputProcessor(im);
		
		//Contact listener
		createCollisionListener();
		enemiesForRemoval = new Array<Enemy>();
		orbForRemoval = new Array<Orb>();
		
		//Score
		score = 0;
		
		//Play music
		music = Gdx.audio.newMusic(Gdx.files.internal("sounds/BergsmatarenLever.ogg"));
		music.setVolume(0.1f);
		music.setLooping(true);
		//music.play();
	}
	
	public void loadLevel(String levelPath)
	{		
		// Bullet array
		bullets = new Array<Bullet>();
		bulletsForRemoval = new Array<Bullet>();

		// Rendering
		world = new FwWorld(levelPath);
		renderer = new WorldRenderer(world, false);
		font = new BitmapFont();

		interfaceTexture = new Texture(Gdx.files.internal("images/dpad.png"));
		interfaceBatch = new SpriteBatch();
		interfaceRenderer = new ShapeRenderer();

		// Input
		controller = new BobController(this, width, height);
		gestureDetector = new GestureDetector(20, 0.5f, 1, 0.15f, controller);
		im = new InputMultiplexer(controller, gestureDetector);
		Gdx.input.setInputProcessor(im);
		
		//Score
		score = 0;

		// Contact listener
		createCollisionListener();
		enemiesForRemoval = new Array<Enemy>();
		orbForRemoval = new Array<Orb>();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		removeBodies();
		
		//Update input
		controller.update(delta);
		
		//Update Bob speed
		this.world.getBob().getBody().setLinearVelocity(controller.linImpulseX + world.getLevel().getSpeed(),controller.linImpulseY);
		
		//Update bullets
		this.checkBulletFire();
		this.moveEnemies();
		
		//Render frame
		renderer.render();
		
		//Render interface
		renderInterface(true);
		//renderFPS();
		
		//Debug reset
//		if(renderer.cameraX > 14)
//		{
//			loadLevel("");
//		}
	}
	
	public void moveEnemies()
	{
		for(MoveableActor en : world.getLevel().getMoveableActors())
    	{
        	if(en instanceof Enemy){
        		if(en.getPosition().x - 6 < renderer.cameraX)
        		{
        			en.getBody().setLinearVelocity(-0.5f, 0);
        		}
        	}
    	}
	}
	
	public void renderInterface(boolean showFPS)
	{
		interfaceRenderer.begin(ShapeType.FilledRectangle);
			interfaceRenderer.setColor(Color.DARK_GRAY);
			interfaceRenderer.filledRect(0, height -30, width, height);
		interfaceRenderer.end();
		interfaceBatch.begin();
		font.setScale(1);
		font.draw(interfaceBatch, "Score:" + score, 10, height -10);
		font.draw(interfaceBatch, "Health:" + (int)this.world.getBob().getHealth()*10 + "%", 100, height -10);
		
		if(showFPS)
		{
			font.draw(interfaceBatch, "FPS:" + Gdx.graphics.getFramesPerSecond(), width - 50, height -10);
		}
		
		if(controller.getDpadCenterX() > 0)
		{
			interfaceBatch.draw(interfaceTexture, controller.getDpadCenterX() - interfaceTexture.getWidth()/4, controller.getDpadCenterY() - interfaceTexture.getHeight()/4, interfaceTexture.getWidth()/2, interfaceTexture.getHeight()/2);
			interfaceBatch.draw(interfaceTexture, controller.getDpadX() - interfaceTexture.getWidth()/2, controller.getDpadY() - interfaceTexture.getHeight()/2, interfaceTexture.getWidth(), interfaceTexture.getHeight());
		}
		interfaceBatch.end();
	}
	
	public void renderFPS()
	{
		interfaceBatch.begin();
		font.setScale(1);
		font.draw(interfaceBatch, "fps:" + Gdx.graphics.getFramesPerSecond(), 0, 20);
		interfaceBatch.end();
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
		
		filter.groupIndex = -8;
		
		float elapsedTime = (System.nanoTime() - timeSinceLastBullet) / 1000000000.0f;
        if(elapsedTime>bulletDelay){
        	timeSinceLastBullet = System.nanoTime();
        	Bullet temp = new Bullet(this.world.getBob().getBody().getWorldPoint(new Vector2(0.8f,0)), world.getWorld(), new Filter());
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
                Orb collisionOrb = null;
                Bob collisionBob = null;
                
                Actor actorA = (Actor)fixtureA.getBody().getUserData();
                Actor actorB = (Actor)fixtureB.getBody().getUserData();
                if(actorA instanceof Enemy){
                	collisionEnemy = (Enemy)actorA;
                } else if (actorB instanceof Enemy){
                	collisionEnemy = (Enemy)actorB;
                }
                
                if(actorA instanceof Orb){
                	collisionOrb = (Orb)actorA;
                } else if (actorB instanceof Orb){
                	collisionOrb = (Orb)actorB;
                }
                
                if(actorA instanceof Bullet){
                	collisionBullet = (Bullet)actorA;
                } else if (actorB instanceof Bullet){
                	collisionBullet = (Bullet)actorB;
                }
                
                if(actorA instanceof Bob){
                	collisionBob = (Bob)actorA;
                } else if(actorB instanceof Bob){
                	collisionBob = (Bob)actorB;
                }
                
                //Gdx.app.log("beginContact", "between " + fixtureA.toString() + " and " + fixtureB.toString());
                
                if(collisionEnemy != null)
                {
                	if(collisionBullet != null){
                		collisionEnemy.setHealth(collisionEnemy.getHealth() - 5);
                	}
                	
                	if(collisionEnemy.getHealth() <= 0)
                	{
                		if(!enemiesForRemoval.contains(collisionEnemy, true))
                    	{
                			renderer.callParticleSystem(collisionEnemy.getBody().getWorldCenter().x, collisionEnemy.getBody().getWorldCenter().y);
                			enemiesForRemoval.add(collisionEnemy);
                    	}
                	}
                }
                                
                if(collisionOrb != null && collisionBullet == null){
                	if(collisionBob != null){
                		score += collisionOrb.getPoints();
                	}
                	
                	if(!orbForRemoval.contains(collisionOrb, true)){
                		orbForRemoval.add(collisionOrb);
                	}
                }
                
                if(collisionBullet != null)
                {
                	if(!bulletsForRemoval.contains(collisionBullet, true))
                	{
                		bulletsForRemoval.add(collisionBullet);
                	}
                }
                
                if(collisionBob != null){
                	if(collisionOrb == null){
                		collisionBob.setHealth(collisionBob.getHealth() - 5);
                	}
                	
                	if(collisionBob.getHealth() <= 0){
                		loadLevel("");
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
	
	public void removeBodies()
	{
		if(!world.getWorld().isLocked())
		{
			for(int i = 0; i < enemiesForRemoval.size; i++)
			{
				Enemy e = enemiesForRemoval.pop();
				Orb toDrop = new Orb(e.getPosition(), e.getWorld(), ActorMgr.getProperties("orb", new StaticActor()), e.getColor(), filter);
				try
				{
					world.getLevel().getMoveableActors().remove(e);
					world.getWorld().destroyBody(e.getBody());
					world.getLevel().addCollectable(toDrop);
				}catch(NullPointerException ex)
				{
					return;
				}
			}
		
			for(int i = 0; i < bulletsForRemoval.size; i++)
			{
				Bullet b = bulletsForRemoval.pop();
				bullets.removeValue(b, true);
				try
				{
					world.getWorld().destroyBody(b.getBody());
				}catch(NullPointerException ex)
				{
					return;
				}
			}
			
			for(int i = 0; i < orbForRemoval.size; i++){
				Orb o = orbForRemoval.pop();
				try
				{
					world.getLevel().getCollectables().remove(o);
					world.getWorld().destroyBody(o.getBody());
				}catch(NullPointerException ex)
				{
					return;
				}
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
		Gdx.input.setInputProcessor(null);
		interfaceBatch.dispose();
		interfaceRenderer.dispose();
		music.stop();
		music.dispose();
		Gdx.app.exit();
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		Gdx.input.setInputProcessor(null);
		interfaceBatch.dispose();
		interfaceRenderer.dispose();
		music.stop();
		music.dispose();
		Gdx.app.exit();
	}
}