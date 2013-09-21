package com.gamegear.firstwing.actors.json;

import java.util.HashMap;

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
}
