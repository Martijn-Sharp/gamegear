package com.gamegear.firstwing.actors.json;

import java.util.List;

public class ActorProperties {
	public String Name;
	
	public float Scale;
	
	public float Width;
	
	public float Height;
	
	public List<Polygon> Polygons;
	
	public ActorProperties(){
	}
	
	public ActorProperties(String name, float scale, float width, float height, List<Polygon> polygons){
		this.Name = name;
		this.Scale = scale;
		this.Width = width;
		this.Height = height;
		this.Polygons = polygons;
	}
}
