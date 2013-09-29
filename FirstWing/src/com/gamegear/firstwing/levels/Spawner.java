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
	private float speed;
	
	public Spawner(com.gamegear.firstwing.levels.json.Spawner spawner, World world, Level level){
		this.position = new Vector2(spawner.X, spawner.Y);
		this.colors = (ArrayList<ColorEnum>) spawner.SpawnColor;
		this.type = spawner.Name;
		this.world = world;
		this.level = level;
		this.speed = spawner.SpawnedActorSpeed;
		this.Spawn();
	}
	
	public void Spawn(){
		ColorEnum color = this.colors.get(new Random().nextInt(this.colors.size()));
		Filter filter = new Filter();
		filter.maskBits = ~4;
		this.level.addMoveableActor(new Enemy(this.position, this.world, ActorMgr.getProperties(this.type, new DynamicActor()), this.type + "-" + color.toString(), filter, this.speed));
	}
	
	public Vector2 getPosition(){
		return position;
	}
}