package com.gamegear.firstwing.levels.json;

import java.util.List;

public class LevelProperties {
	public enum ColorEnum{
		Blue,
		Green,
		LightBlue,
		Orange,
		Purple,
		Red,
		Yellow
	}
	
	public float FinishX;
	
    public float SpawnX;
    
    public float SpawnY;
    
    public String BackgroundName;
    
    public List<SpeedPoint> SpeedPoints;
    
    public List<ColorEnum> Colors;

    public List<Node> Tiles;
    
    public List<Node> Enemies;
}
