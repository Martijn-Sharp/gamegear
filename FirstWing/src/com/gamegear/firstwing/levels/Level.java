package com.gamegear.firstwing.levels;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.gamegear.firstwing.ActorMgr;
import com.gamegear.firstwing.actors.*;
import com.gamegear.firstwing.actors.json.DynamicActor;
import com.gamegear.firstwing.actors.json.StaticActor;
import com.gamegear.firstwing.levels.json.*;

public class Level {

	private int width;
	private int height;
	private ArrayList<Block> blocks;
	private ArrayList<Enemy> enemies;
	private Queue<String> speed;
	private World world;
	private int currentSpeed = 5;
	private String levelPath;
	private Sprite background;

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

	public ArrayList<Block> getBlocks() {
		return blocks;
	}
	
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public void setBlocks(ArrayList<Block> blocks) {
		this.blocks = blocks;
	}

	public Level(World world, String levelPath) {
		this.world = world;
		this.levelPath = levelPath;
		loadLevel();
	}
	
	public Actor get(int x) {
		return blocks.get(x);
	}
	
	public int getSpeed(float cameraX)
	{
		if(!speed.isEmpty())
		{
			String[] tmpSpeed = speed.peek().split(",");
			if(Integer.parseInt(tmpSpeed[0]) < cameraX)
			{
				currentSpeed = Integer.parseInt(tmpSpeed[1]);
				speed.remove();
			}
		}
		return currentSpeed;
	}
	
	public int getSpeed()
	{
		return currentSpeed;
	}
	
	public Sprite getBackground(){
		return this.background;
	}

	private void loadLevel() {
		height = 10;
		width = 0;
		blocks = new ArrayList<Block>();
		enemies = new ArrayList<Enemy>();
		speed = new LinkedList<String>();
		LevelProperties levelLoader;
		
		if(levelPath.isEmpty())
		{
			levelLoader = new JSONLoader().getLevel(Gdx.files.internal("levels/map7.dat"));
		}
		else
		{
			levelLoader = new JSONLoader().getLevel(Gdx.files.internal("levels/" + levelPath));
		}
		
		Iterator<Node> tiles = levelLoader.Tiles.iterator();
		Iterator<Node> enemiesIt = levelLoader.Enemies.iterator();
		
		while(tiles.hasNext()){
			Node tile = tiles.next();
			
			//Check level width
			if(tile.X > width)
			{
				width = tile.X;
			}
			
			blocks.add(new Block(new Vector2(tile.X, tile.Y), world, ActorMgr.getProperties(tile.Name, new StaticActor())));
			tiles.remove();
		}
		
		while(enemiesIt.hasNext()){
			Node enemy = enemiesIt.next();
			enemies.add(new Enemy(new Vector2(enemy.X, enemy.Y), world, ActorMgr.getProperties(enemy.Name, new DynamicActor())));
			enemiesIt.remove();
		}
		
		this.background = new Sprite(new Texture(Gdx.files.internal("images/" + levelLoader.BackgroundName + ".png")));
		this.background.setSize(24f, 18f);
		this.background.setScale(1f, 1f);
		
		//Add demo speeds
		speed.add("0,1");
		speed.add("6,1");
		speed.add("15,0");
	}
}