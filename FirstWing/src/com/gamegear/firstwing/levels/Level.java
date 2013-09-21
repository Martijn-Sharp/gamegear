package com.gamegear.firstwing.levels;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
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
	private World world;

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

	public Level(World world) {
		this.world = world;
		loadDemoLevel();
	}
	
	public Actor get(int x) {
		return blocks.get(x);
	}

	private void loadDemoLevel() {
		width = 100;
		height = 10;
		blocks = new ArrayList<Block>();
		enemies = new ArrayList<Enemy>();
		
		com.gamegear.firstwing.levels.json.Level LevelLoader = new JSONLoader().getLevel(Gdx.files.internal("levels/map5.dat"));
		Iterator<Tile> tiles = LevelLoader.tiles.iterator();
		Iterator<EnemySpawner> enemiesIt = LevelLoader.enemies.iterator();
		
		while(tiles.hasNext()){
			Tile tile = tiles.next();
			blocks.add(new Block(new Vector2(tile.xCoord, tile.yCoord), world, ActorMgr.getProperties(tile.name, new StaticActor())));
			tiles.remove();
		}
		
		while(enemiesIt.hasNext()){
			EnemySpawner enemy = enemiesIt.next();
			enemies.add(new Enemy(new Vector2(enemy.xCoord, enemy.yCoord), world, ActorMgr.getProperties(enemy.name, new DynamicActor())));
			enemiesIt.remove();
		}
	}
}