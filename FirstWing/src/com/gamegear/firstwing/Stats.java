package com.gamegear.firstwing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.gamegear.firstwing.levels.json.LevelProperties.ColorEnum;

public class Stats {
	private Preferences prefs;
	public long currentScore;
	private FirstWing firstwing;
	
	public ColorEnum currentColor;
	public long comboOrbs;
	public float modifier;
	
	public long upgradeWeapon = 0;
	public long upgradeHealth = 0;
	
	public int levelID = 0;
	
	public boolean noColorChanges = true;

	public HashMap<String, Long> collectedOrbsColor;
	
	public Stats(FirstWing firstwing)
	{
		this.currentScore = 0;
		this.modifier = 1.0f;
		this.collectedOrbsColor = new HashMap<String, Long>();
		this.currentColor = ColorEnum.none;
		this.firstwing = firstwing;
		
		//Get preferences
		prefs = Gdx.app.getPreferences("ColorExpress");
		loadPreferences();
	}
	
	public void loadPreferences()
	{
		for(ColorEnum en : ColorEnum.values())
		{
			 collectedOrbsColor.put(en.name(), prefs.getLong(en.name(), 0l));
		}
	}
	
	public boolean addScore(ColorEnum colorEnum, float enemyScore)
	{
		boolean changed;
		//Reset modifier
		if(this.currentColor != colorEnum)
		{
			this.modifier = 1f;
			this.comboOrbs = 0;
			
			//For color achievements
			if(this.currentColor != ColorEnum.none)
			{
				noColorChanges = false;
			}
			this.currentColor = colorEnum;
			changed = true;
		}
		else
		{
			this.modifier += 1;
			this.comboOrbs++;
			changed = false;
		}
		
		if(this.collectedOrbsColor.containsKey(colorEnum.name()))
		{
			this.collectedOrbsColor.put(colorEnum.name(), (long) (this.collectedOrbsColor.get(colorEnum.name()) + (enemyScore * this.modifier)));
		}
		else
		{
			this.collectedOrbsColor.put(colorEnum.name(), 1l);
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
		if(getHighScore(levelID) < currentScore)
		{
			setHighScore(levelID, currentScore);
		}
		
		Iterator<Entry<String, Long>> it = collectedOrbsColor.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<String, Long> pairs = (Entry<String, Long>)it.next();
	        prefs.putLong(pairs.getKey(), prefs.getLong(pairs.getKey()) + pairs.getValue());
	        System.out.println(pairs.getKey() + " = " + prefs.getLong(pairs.getKey()));
	        it.remove();
	    }
	    prefs.flush();
		
	    currentColor = ColorEnum.none;
		currentScore = 0;
		modifier = 1f;
		comboOrbs = 0;
	}
	
	public void changeLevel(int levelID)
	{
		resetScore();
		this.levelID = levelID;
	}

	public long getHighScore(int levelID) {
		return this.prefs.getLong("highscore" + levelID, 0l);
	}

	public void setHighScore(int levelID, long highScore) {
		//Store highscore locally
		prefs.putLong("highscore" + levelID, currentScore);
		
		if(firstwing.platformInterface.getSignedIn())
		{
			firstwing.platformInterface.submitScore(highScore);
			switch(levelID)
			{
				case 1:		firstwing.platformInterface.submitScore("CgkIhpLNkp8BEAIQCg" ,highScore);
					break;
				case 2:		firstwing.platformInterface.submitScore("CgkIhpLNkp8BEAIQCw" ,highScore);
					break;
				case 3:		firstwing.platformInterface.submitScore("CgkIhpLNkp8BEAIQDA" ,highScore);
					break;
			}
		}
	}
	
	public boolean checkColorAchievement()
	{
		if(currentColor == ColorEnum.blue && noColorChanges)
		{
			firstwing.platformInterface.unlockAchievement("CgkIhpLNkp8BEAIQAg");
			return true;
		}
		else if(currentColor == ColorEnum.yellow && noColorChanges)
		{
			firstwing.platformInterface.unlockAchievement("CgkIhpLNkp8BEAIQCQ");
			return true;
		}
		else if(currentColor == ColorEnum.red && noColorChanges)
		{
			firstwing.platformInterface.unlockAchievement("CgkIhpLNkp8BEAIQCA");
			return true;
		}
		return false;
	}

	public long getComboOrbs() {
		return comboOrbs;
	}
}
