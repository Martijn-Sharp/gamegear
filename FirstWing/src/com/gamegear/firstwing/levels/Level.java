package com.gamegear.firstwing.levels;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.gamegear.firstwing.actors.*;

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
		
		LoadedLevel LevelLoader = new JSONLoader(Gdx.files.internal("levels/map3.dat")).getLevel();
		Iterator<Tile> tiles = LevelLoader.tiles.iterator();
		Iterator<EnemySpawner> enemiesIt = LevelLoader.enemies.iterator();
		
		while(tiles.hasNext()){
			Tile tile = tiles.next();
			blocks.add(new Block(new Vector2(tile.xCoord, tile.yCoord), world, "block"));
			tiles.remove();
		}
		
		while(enemiesIt.hasNext()){
			EnemySpawner enemy = enemiesIt.next();
			enemies.add(new Enemy(new Vector2(enemy.xCoord, enemy.yCoord), world));
			enemiesIt.remove();
		}
		
//		Iterator<Entry<String, Tile>> it = LevelLoader.entrySet().iterator();
//	    
//		while (it.hasNext()) {
//	        Map.Entry<String, Tile> pairs = (Map.Entry<String, Tile>)it.next();
//	        Tile tile = pairs.getValue();
//	        
//	        // Load tiles into level
//	        if(tile.level)
//	        {
//	        	blocks[tile.xCoord][tile.yCoord] = new Block(new Vector2(tile.xCoord, tile.yCoord), world, "block");
//	        }
//	        else if (tile.enemy) {
//	        	blocks[tile.xCoord][tile.yCoord] = new Enemy(new Vector2(tile.xCoord, tile.yCoord), world);
//	        }
//	        else
//	        {
//	        	System.out.println("Not a level tile");
//	        }
//	        
//	        it.remove();
//	    }
	}
}