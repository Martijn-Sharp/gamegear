package com.gamegear.firstwing.levels.json;

public class Node {
	public enum NodeType{
		Spawner,
		Tile
	}
	
	//Coordinates on local map
    public int X;
    
    public int Y;

    //Properties
    public int Id;
    
    public String Name;
    
    public NodeType Type;
    
    public Node(int x, int y)
    {
        this.X = x;
        this.Y = y;
    }
    
    public Node()
    {
    	
    }
}
