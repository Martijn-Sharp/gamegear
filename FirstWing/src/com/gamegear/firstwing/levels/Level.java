package com.gamegear.firstwing.levels;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.gamegear.firstwing.actors.*;

public class Level {

	private int width;
	private int height;
	private Actor[][] blocks;
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

	public Actor[][] getBlocks() {
		return blocks;
	}

	public void setBlocks(Block[][] blocks) {
		this.blocks = blocks;
	}

	public Level(World world) {
		this.world = world;
		loadDemoLevel();
	}
	
	public Actor get(int x, int y) {
		return blocks[x][y];
	}

	private void loadDemoLevel() {
		width = 100;
		height = 10;
		blocks = new Actor[width][height];
		
		Map<String, Tile> LevelLoader = new JSONLoader(Gdx.files.internal("levels/map2.dat")).getLevel();
		Iterator<Entry<String, Tile>> it = LevelLoader.entrySet().iterator();
	    
		while (it.hasNext()) {
	        Map.Entry<String, Tile> pairs = (Map.Entry<String, Tile>)it.next();
	        Tile tile = pairs.getValue();
	        
	        // Load tiles into level
	        if(tile.level)
	        {
	        	blocks[tile.xCoord][tile.yCoord] = new Block(new Vector2(tile.xCoord, tile.yCoord), world, "block");
	        }
	        else if (tile.enemy) {
	        	blocks[tile.xCoord][tile.yCoord] = new Enemy(new Vector2(tile.xCoord, tile.yCoord), world);
	        }
	        else
	        {
	        	System.out.println("Not a level tile");
	        }
	        
	        it.remove();
	    }
	}
}