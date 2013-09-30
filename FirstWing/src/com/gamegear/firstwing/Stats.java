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
		this.setHighScore(this.prefs.getLong("highscore", 0l));
	}
	
	public boolean addScore(ColorEnum colorEnum, float enemyScore)
	{
		boolean changed;
		//Reset modifier
		if(this.currentColor != colorEnum)
		{
			this.modifier = 1f;
			this.comboOrbs = 0;
			this.currentColor = colorEnum;
			changed = true;
		}
		else
		{
			this.modifier += 1;
			this.comboOrbs++;
			changed = false;
		}
		
		if(this.collectedOrbsColor.containsKey(colorEnum))
		{
			this.collectedOrbsColor.put(colorEnum, this.collectedOrbsColor.get(colorEnum) + 1);
		}
		else
		{
			this.collectedOrbsColor.put(colorEnum, 1l);
		}
		
		this.currentScore += enemyScore * this.modifier;
		
		return changed;
	}
	
	public void addScore(float points)
	{
		this.currentScore += points * this.modifier;
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
