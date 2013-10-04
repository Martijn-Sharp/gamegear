package com.gamegear.firstwing.screens;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
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
import com.gamegear.firstwing.FirstWing;
import com.gamegear.firstwing.FwWorld;
import com.gamegear.firstwing.WorldRenderer;
import com.gamegear.firstwing.actors.*;
import com.gamegear.firstwing.actors.json.StaticActor;
import com.gamegear.firstwing.levels.Spawner;
import com.gamegear.firstwing.levels.json.Tile;

public class GameScreen implements Screen {

	public FirstWing		game;
	public FwWorld 			world;
	public WorldRenderer 	renderer;
	public BobController	controller;
	public GestureDetector 	gestureDetector;
	public Texture 			interfaceTexture;
	public SpriteBatch 		interfaceBatch;
	public ShapeRenderer 	interfaceRenderer;
	public BitmapFont 		font;
	public Music			music;
	public boolean			markedForRestart = false;
	public FreeTypeFontGenerator 	fontGenerator;
	public Array<Actor>		actorsForRemoval;
	public int			levelPath;
	
	// Bullets
	private Array<Bullet> 	bullets;
	long					timeSinceLastBullet;
	
	long					timeSinceDamage = 0;
	
	InputMultiplexer im;
	
	private int width, height;
	private boolean finished;
	
	public GameScreen(FirstWing game, int levelPath)
	{
		this.game = game;
		this.levelPath = levelPath;
	}
	
	@Override
	public void show() {
		//Bullet array
		bullets = new Array<Bullet>();
		bullets.ensureCapacity(20);
		
		//Rendering
		world = new FwWorld(String.valueOf(levelPath));
		
		renderer = new WorldRenderer(world, false);
		
		fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("ui/TiresiasScreenfont.ttf"));
		//font = fontGenerator.generateFont(30, "abcdefghijklmnopqrstuvwxyz:1234567890", true);
		font = fontGenerator.generateFont(16);
		fontGenerator.dispose();

		
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
		this.actorsForRemoval = new Array<Actor>();
		
		//Play music
		//music = Gdx.audio.newMusic(Gdx.files.internal("sounds/BergsmatarenLever.ogg"));
		music = Gdx.audio.newMusic(Gdx.files.internal("sounds/TeleportPro.ogg"));
		music.setVolume(FirstWing.options.getVolume());
		music.setLooping(true);
		if(FirstWing.options.musicEnabled())
		{
			music.play();
		}
	}
	
	public void loadLevel(int levelPath)
	{
		// Bullet array
		bullets = new Array<Bullet>();
		bullets.ensureCapacity(20);
		this.actorsForRemoval = new Array<Actor>();

		// Rendering
		world.getWorld().dispose();
		world = new FwWorld(String.valueOf(levelPath));
		renderer.reset(world);
		//renderer = new WorldRenderer(world, false);

		//Score
		FirstWing.stats.resetScore();

		// Contact listener
		createCollisionListener();
		System.gc();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		removeBodies();
		if(this.finished){
			this.finished = false;
			
			// Completed first level
			if(this.levelPath == 1)
			{
				game.platformInterface.unlockAchievement("CgkIhpLNkp8BEAIQBA");
			}
			
			this.levelPath += 1;
			this.loadLevel(this.levelPath);
		}
		
		if(this.markedForRestart)
		{
			this.loadLevel(this.levelPath);
			this.markedForRestart = false;
		}
		
		//Update input
		controller.update(delta);
		checkPlayerBounds();
		
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
		Iterator<Spawner> it = world.getLevel().getSpawners().iterator();
		while(it.hasNext()){
			Spawner spawner = it.next();
			if(spawner.getPosition().x -6 < renderer.cameraX){
				spawner.Spawn();
			} else {
				return;
			}
			
			if(spawner.getPosition().x < renderer.cameraX){
				world.getLevel().getSpawners().remove(spawner);
			}
			
			it.remove();
		}
	}
	
	public void checkPlayerBounds()
	{
		if(renderer.cameraX - 4f >= world.getBob().getPosition().x && -(controller.dpadCenterX - controller.dpadX) < 0){ 
			controller.linImpulseX = 0;
		}
		else if(renderer.cameraX - 5f >= world.getBob().getPosition().x){
			markedForRestart = true;
		}
		else{
			//controller.linImpulseX = 0;
		}
		if(renderer.cameraX + 4f <= world.getBob().getPosition().x && -(controller.dpadCenterX - controller.dpadX) > 0){
			controller.linImpulseX = 0;
		}
		else if(renderer.cameraX + 5f <= world.getBob().getPosition().x){
			markedForRestart = true;
		}
		else{
			//controller.linImpulseX = 0;
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
		font.draw(interfaceBatch, "Score:" + FirstWing.stats.getScore(), 10, height -10);
		font.draw(interfaceBatch, "Highscore:" + FirstWing.stats.getHighScore(), 100, height -10);
		font.draw(interfaceBatch, "Health:" + (int)this.world.getBob().getHealth()*10 + "%", 200, height -10);
		font.draw(interfaceBatch, "Combo:" + FirstWing.stats.getComboOrbs() + "x", 300, height -10);
		
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
	
	public void checkBulletFire()
	{
		int maxBullets = 10;
		
		// Maximum bullets on screen
        if(bullets.size > maxBullets)
        {
        	this.actorsForRemoval.add(bullets.get(0));
        	bullets.removeIndex(0);
        }
        
        // Remove bullets off screen
        for(Bullet b : bullets)
        {
        	if(b.getBody().getWorldCenter().x > renderer.cameraX + (renderer.getCam().viewportWidth / 2))
        	{
        		this.actorsForRemoval.add(b);
        		bullets.removeValue(b, true);
        	}
        }
		
		//Bullet delay in seconds
		float bulletDelay = 0.8f;
		
		Filter filter = new Filter();
		filter.categoryBits = 1;
		filter.groupIndex = -2;
		
		float elapsedTime = (System.nanoTime() - timeSinceLastBullet) / 1000000000.0f;
        if(elapsedTime > bulletDelay){
        	timeSinceLastBullet = System.nanoTime();
        	Bullet temp = new Bullet(this.world.getBob().getBody().getWorldPoint(new Vector2(0.8f,0)), world.getWorld(), filter, FirstWing.stats.currentColor);
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
                Block collisionBlock = null;
                
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
                
                if(actorA instanceof Block){
                	collisionBlock = (Block)actorA;
                } else if(actorB instanceof Block){
                	collisionBlock = (Block)actorB;
                }
                
                // Als een bullet in aanraking komt
                if(collisionBullet != null)
                {
                	if(collisionEnemy != null){
                		collisionEnemy.setHealth(collisionEnemy.getHealth() - 5);
                		if(collisionEnemy.getHealth() <= 0)
                    	{
                    		if(!actorsForRemoval.contains(collisionEnemy, true))
                        	{
                    			renderer.callParticleSystem(collisionEnemy.getBody().getWorldCenter().x, collisionEnemy.getBody().getWorldCenter().y);
                    			FirstWing.stats.addScore(10f);
                    			actorsForRemoval.add(collisionEnemy);
                        	}
                    	}
                	} else if(collisionBlock != null && collisionBlock.isBreakable()){
                		collisionBlock.setHealth(collisionBlock.getHealth() - 2f, collisionBullet.getColor());
                		if(collisionBlock.getHealth() <= 0){
                    		if(!actorsForRemoval.contains(collisionBlock, true))
                        	{
                    			actorsForRemoval.add(collisionBlock);
                        	}
                    	}
                	}
                	
                	if(!actorsForRemoval.contains(collisionBullet, true))
                	{
                		actorsForRemoval.add(collisionBullet);
                	}
                }
                
                // Als het schip in aanraking komt
                if(collisionBob != null){
                	if(collisionBlock != null){
                		switch(((StaticActor)collisionBlock.getProperties()).Type){
						case Breakable:
							collisionBob.setHealth(0f);
							break;
						case Finish:
							finished = true;
							break;
						case Tile:
							if(timeSinceDamage + 100 < System.currentTimeMillis()){
								collisionBob.setHealth(collisionBob.getHealth() - 0.1f);
								timeSinceDamage = System.currentTimeMillis();
							}
							break;
						default:
							break;
        				}
                	} else if(collisionOrb != null){
                		if(FirstWing.stats.addScore(collisionOrb.getColor(), collisionOrb.getPoints()))
                		{
                			renderer.changeAfterBurnerColor(collisionOrb.getColor());
                		}
                		
                		if(!actorsForRemoval.contains(collisionOrb, true)){
                    		actorsForRemoval.add(collisionOrb);
                    	}
                	} else if(collisionOrb == null && collisionBullet == null && timeSinceDamage + 1000 < System.currentTimeMillis()){
                		timeSinceDamage = System.currentTimeMillis();
                		collisionBob.setHealth(collisionBob.getHealth() - 5);
                	}
                	
                	if(collisionBob.getHealth() <= 0){
                		markedForRestart = true;
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
			for(int i = 0; i < this.actorsForRemoval.size; i++){
				Actor actor = this.actorsForRemoval.pop();
				if(actor instanceof Enemy){
					Enemy enemy = (Enemy) actor;
					Filter filter = new Filter();
					filter.categoryBits = 4;
					filter.groupIndex = -2;
					Orb toDrop = new Orb(enemy.getPosition(), enemy.getWorld(), ActorMgr.getProperties("orb", new StaticActor()), enemy.getColor(), filter);
					world.getLevel().getMoveableActors().remove(enemy);
					world.getLevel().addCollectable(toDrop);
				} else if(actor instanceof Bullet){
					Bullet bullet = (Bullet) actor;
					bullets.removeValue(bullet, true);
				} else if(actor instanceof Orb){
					Orb orb = (Orb) actor;
					world.getLevel().getCollectables().remove(orb);
				}
				
				try{
					this.world.getWorld().destroyBody(actor.getBody());
				} catch (NullPointerException ex){
					Gdx.app.log("Destroy Body", ex.getStackTrace().toString());
					return;
				}
			}
		}
		else
		{
			try {
				Thread.sleep(5);
				removeBodies();
			} catch (InterruptedException e) {}
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
		Gdx.app.exit();
	}

	@Override
	public void pause() {
		Gdx.app.exit();
	}

	@Override
	public void resume() {
		loadLevel(1);
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