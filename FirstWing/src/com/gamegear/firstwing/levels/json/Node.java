package com.gamegear.firstwing.levels.json;

public class Node {
	//Coordinates on local map
    public int xCoord, yCoord;

    //Properties
    public int id;
    public String name;
    public int animationLength;
    
    public Node(int x, int y)
    {
        this.xCoord = x;
        this.yCoord = y;
    }
    
    public Node()
    {
    	
    }
}
