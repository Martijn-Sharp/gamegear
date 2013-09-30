package com.gamegear.firstwing.levels;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.World;
import com.gamegear.firstwing.ActorMgr;
import com.gamegear.firstwing.actors.*;
import com.gamegear.firstwing.actors.json.StaticActor;
import com.gamegear.firstwing.levels.json.*;

public class Level {

	private int width;
	private int height;
	private ArrayList<Actor> staticActors;
	private ArrayList<MoveableActor> dynamicActors;
	private ArrayList<Spawner> spawners;
	private ArrayList<Orb> collectables;
	private Queue<SpeedPoint> speed;
	private World world;
	private int currentSpeed = 5;
	private String levelPath;
	private ArrayList<Sprite> background;
	private Bob playerShip;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public ArrayList<Actor> getStaticActors() {
		return staticActors;
	}
	
	public void addStaticActor(Actor actor){
		this.staticActors.add(actor);
	}
	
	public ArrayList<MoveableActor> getMoveableActors() {
		return this.dynamicActors;
	}
	
	public void addMoveableActor(MoveableActor enemy){
		this.dynamicActors.add(enemy);
	}
	
	public ArrayList<Orb> getCollectables(){
		return this.collectables;
	}
	
	public void addCollectable(Orb orb){
		this.collectables.add(orb);
	}
	
	public void setBlocks(ArrayList<Actor> blocks) {
		this.staticActors = blocks;
	}
	
	public Bob getPlayer(){
		return this.playerShip;
	}

	public Level(World world, String levelPath) {
		this.world = world;
		this.levelPath = levelPath;
		this.loadLevel();
	}
	
	public Actor get(int x) {
		return staticActors.get(x);
	}
	
	public float getSpeed(float cameraX)
	{
		if(!speed.isEmpty())
		{
			SpeedPoint tmpSpeed = speed.peek();
			if(tmpSpeed.X < cameraX)
			{
				currentSpeed = (int) tmpSpeed.Speed;
				speed.remove();
			}
		}
		
		return currentSpeed;
	}
	
	public int getSpeed()
	{
		return currentSpeed;
	}
	
	public ArrayList<Sprite> getBackground(){
		return this.background;
	}

	private void loadLevel() {
		this.staticActors = new ArrayList<Actor>();
		this.dynamicActors = new ArrayList<MoveableActor>();
		this.spawners = new ArrayList<Spawner>();
		this.collectables = new ArrayList<Orb>();
		this.speed = new LinkedList<SpeedPoint>();
		this.background = new ArrayList<Sprite>();
		LevelProperties levelLoader;
		
		if(levelPath.isEmpty())
		{
			levelLoader = new JSONLoader().getLevel(Gdx.files.internal("levels/map14.dat"));
		}
		else
		{
			levelLoader = new JSONLoader().getLevel(Gdx.files.internal("levels/" + levelPath));
		}
		
		Iterator<Node> tiles = levelLoader.Tiles.iterator();
		Iterator<com.gamegear.firstwing.levels.json.Spawner> spawnerIt = levelLoader.Spawners.iterator();
		Filter filter = new Filter();
		
		// PLAYER
		this.playerShip = new Bob(new Vector2(levelLoader.SpawnX, levelLoader.SpawnY), this.world, new Filter());
		
		// TILES
		while(tiles.hasNext()){
			Node tile = tiles.next();
			
			// Check level width
			if(tile.X > width)
			{
				width = tile.X;
			}
			
			staticActors.add(new Block(new Vector2(tile.X, tile.Y), world, ActorMgr.getProperties(tile.Name, new StaticActor()),filter));
			tiles.remove();
		}
		
		// SPAWNERS
		while(spawnerIt.hasNext()){
			com.gamegear.firstwing.levels.json.Spawner spawner = spawnerIt.next();
			this.spawners.add(new Spawner(spawner, this.world, this));
			spawnerIt.remove();
		}
		
		// BACKGROUND
		for(int x = 0; x < Math.ceil(levelLoader.FinishX / 4); x++){
			for(int y = 0; y < 3; y++){
				Sprite tempBg = new Sprite(new Texture(Gdx.files.internal("images/" + levelLoader.BackgroundName + ".png")));
				tempBg.setSize(4f, 4f);
				tempBg.setScale(1f);
				tempBg.setPosition(x * 4f - 0.5f, y * 4f - 0.5f);
				this.background.add(tempBg);
			}
		}
		
		// SPEED
		speed.add(new SpeedPoint(0, 1));
		if(levelLoader.SpeedPoints != null){
			for(SpeedPoint sp : levelLoader.SpeedPoints){
				speed.add(sp);
			}
		}
		speed.add(new SpeedPoint(levelLoader.FinishX - 6f, 0));
	}
}