package com.gamegear.firstwing;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.gamegear.firstwing.levels.json.LevelProperties.ColorEnum;

public class Stats {
	private Preferences prefs;
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
		
		//Get preferences
		prefs = Gdx.app.getPreferences("ColorExpress");
		loadHighscore();
		
		this.currentColor = ColorEnum.none;
		collectedOrbsColor = new HashMap<ColorEnum, Long>();
	}
	
	public void loadHighscore()
	{
		this.setHighScore(prefs.getLong("highscore", 0l));
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
			prefs.putLong("highscore", currentScore);
			setHighScore(currentScore);
			prefs.flush();
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
