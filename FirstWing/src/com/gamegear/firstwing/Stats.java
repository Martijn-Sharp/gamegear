package com.gamegear.firstwing;

import java.util.HashMap;

import com.gamegear.firstwing.levels.json.LevelProperties.ColorEnum;

public class Stats {
	public long currentScore;
	private long highScore;
	
	public ColorEnum currentColor;
	public long comboOrbs;
	public float modifier;

	public HashMap<ColorEnum, Long> collectedOrbsColor;
	
	public Stats()
	{
		this.currentScore = 0;
		this.modifier = 1.0f;
		this.setHighScore(0);
		this.currentColor = ColorEnum.blue;
		collectedOrbsColor = new HashMap<ColorEnum, Long>();
	}
	
	public void loadHighscore()
	{
		//TODO load highscore
	}
	
	public boolean addScore(ColorEnum colorEnum, float enemyScore)
	{
		boolean changed;
		//Reset modifier
		if(currentColor != colorEnum)
		{
			modifier = 1f;
			comboOrbs = 0;
			currentColor = colorEnum;
			changed = true;
		}
		else
		{
			modifier += 0.5;
			comboOrbs++;
			changed = false;
		}
		if(collectedOrbsColor.containsKey(colorEnum))
		{
			collectedOrbsColor.put(colorEnum, collectedOrbsColor.get(colorEnum) + 1);
		}
		else
		{
			collectedOrbsColor.put(colorEnum, 1l);
		}
		
		currentScore += (long) (enemyScore * modifier);
		
		return changed;
	}
	
	public void addScore(int points)
	{
		currentScore += points;
	}
	
	public long getScore()
	{
		return currentScore;
	}
	
	public void resetScore()
	{
		if(getHighScore() < currentScore)
		{
			setHighScore(currentScore);
		}
		
		currentScore = 0;
		modifier = 1f;
		comboOrbs = 0;
	}

	public long getHighScore() {
		return highScore;
	}

	public void setHighScore(long highScore) {
		this.highScore = highScore;
	}

	public long getComboOrbs() {
		return comboOrbs;
	}
}
