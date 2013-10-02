package com.gamegear.firstwing.levels.json;

import java.util.List;

public class LevelProperties {
	public enum ColorEnum{
		blue,
		green,
		lightblue,
		orange,
		purple,
		red,
		yellow,
		none
	}
	
	public float FinishX;
	
    public float SpawnX;
    
    public float SpawnY;
    
    public String BackgroundName;
    
    public ColorEnum LevelColor;
    
    public List<SpeedPoint> SpeedPoints;
    
    public List<ColorEnum> Colors;

    public List<Tile> Tiles;
    
    public List<Spawner> Spawners;
}
