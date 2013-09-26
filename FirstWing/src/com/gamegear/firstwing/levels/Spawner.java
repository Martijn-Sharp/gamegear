package com.gamegear.firstwing.levels;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.World;
import com.gamegear.firstwing.ActorMgr;
import com.gamegear.firstwing.actors.Enemy;
import com.gamegear.firstwing.actors.json.DynamicActor;
import com.gamegear.firstwing.levels.json.LevelProperties.ColorEnum;

public class Spawner {
	private World world;
	private String type;
	private ArrayList<ColorEnum> colors;
	private Vector2 position;
	private Level level;
	
	public Spawner(Vector2 position, World world, String type, ArrayList<ColorEnum> colors, Level level){
		this.position = position;
		this.world = world;
		this.colors = colors;
		this.level = level;
		this.type = type;
		this.Spawn();
	}
	
	public void Spawn(){
		ColorEnum color = this.colors.get(new Random().nextInt(this.colors.size()));
		Filter filter = new Filter();
		filter.groupIndex = -8;
		this.level.addMoveableActor(new Enemy(this.position, this.world, ActorMgr.getProperties(this.type, new DynamicActor()), this.type + "-" + color.toString(), filter));
	}
	
	public Vector2 getPosition(){
		return position;
	}
}
