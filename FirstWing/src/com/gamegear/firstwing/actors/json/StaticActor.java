package com.gamegear.firstwing.actors.json;

import java.util.List;

public class StaticActor extends ActorProperties {
	public StaticActor(){
		super();
	}
	
	public StaticActor(String name, float scale, float width, float height, List<Polygon> polygons){
		super(name, scale, width, height, polygons);
	}
}
