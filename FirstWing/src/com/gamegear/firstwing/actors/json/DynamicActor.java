package com.gamegear.firstwing.actors.json;

import java.util.HashMap;
import java.util.List;

public class DynamicActor extends ActorProperties {
	public enum Weapon{
		None,
		FodderGun,
		MissileLauncher,
		EnergyballGun
	}
	
	public enum Animation{
		Left,
		Up,
		Down
	}
	
	public float Speed;
	
	public float Health;
	
	public Weapon PrimaryWeapon;
	
	public Weapon SecondaryWeapon;
	
	public HashMap<Animation, Integer> Animations;
	
	public DynamicActor(){
		super();
	}
	
	public DynamicActor(float speed, float health, String name, float scale, float width, float height, List<Polygon> polygons){
		super(name, scale, width, height, polygons);
		this.Speed = speed;
		this.Health = health;
	}
}
