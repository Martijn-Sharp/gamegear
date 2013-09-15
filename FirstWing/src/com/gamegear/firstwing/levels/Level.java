package com.gamegear.firstwing.levels;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.gamegear.firstwing.actors.Block;

public class Level {

	private int width;
	private int height;
	private Block[][] blocks;
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

	public Block[][] getBlocks() {
		return blocks;
	}

	public void setBlocks(Block[][] blocks) {
		this.blocks = blocks;
	}

	public Level(World world) {
		this.world = world;
		loadDemoLevel();
	}
	
	public Block get(int x, int y) {
		return blocks[x][y];
	}

	private void loadDemoLevel() {
		width = 100;
		height = 10;
		blocks = new Block[width][height];
		
		Map<String, Tile> LevelLoader = new JSONLoader(Gdx.files.internal("levels/map.dat")).getLevel();
		Iterator<Entry<String, Tile>> it = LevelLoader.entrySet().iterator();
	    
		while (it.hasNext()) {
	        Map.Entry<String, Tile> pairs = (Map.Entry<String, Tile>)it.next();
	        
	        //Load tiles into level
	        if(pairs.getValue().level)
	        {
	        	blocks[pairs.getValue().xCoord][pairs.getValue().yCoord] = new Block(new Vector2(pairs.getValue().xCoord, pairs.getValue().yCoord), world);
	        }
	        else
	        {
	        	System.out.println("Not a level tile");
	        }
	        it.remove();
	    }
	}
}