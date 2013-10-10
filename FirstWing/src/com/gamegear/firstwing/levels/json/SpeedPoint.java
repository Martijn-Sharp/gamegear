package com.gamegear.firstwing.levels.json;

public class SpeedPoint implements Comparable<SpeedPoint> {
	public float X;
	
	public float Speed;
	
	public SpeedPoint(){
	}
	
	public SpeedPoint(float x, float speed){
		this.X = x;
		this.Speed = speed;
	}

	@Override
	public int compareTo(SpeedPoint o) {
		int compare;
		if(this.X > o.X){
			compare = 1;
		} else if(this.X == o.X){
			compare = 0;
		} else {
			compare = -1;
		}
		return compare;
	}
}
