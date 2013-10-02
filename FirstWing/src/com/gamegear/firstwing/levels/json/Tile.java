package com.gamegear.firstwing.levels.json;

import com.gamegear.firstwing.levels.json.LevelProperties.ColorEnum;

public class Tile extends Node {
	public float Health;
	
	public ColorEnum AssignedColor;
	
	public Tile(int x, int y)
    {
    	super(x,y);
    }
    
    public Tile(){
    }
}
