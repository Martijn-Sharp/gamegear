package com.gamegear.firstwing.levels.json;

import java.util.List;

public class Spawner extends Node
{
    public List<LevelProperties.ColorEnum> SpawnColor;

    public float SpawnedActorSpeed;

    public Boolean Multiple;

    public float SpawnInterval;

    public Spawner(int x, int y)
    {
    	super(x,y);
    }
    
    public Spawner(){
    }
}