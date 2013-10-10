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
	public long totalKilled;
	
	public long upgradeWeapon = 0;
	public long upgradeHealth = 0;
	
	public boolean trophy = false;
	
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
		totalKilled = prefs.getLong("enemies.total", 0l);
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
		
		if(comboOrbs == 5 && firstwing.platformInterface.getSignedIn())
		{
			firstwing.platformInterface.unlockAchievement("CgkIhpLNkp8BEAIQBQ");
		}
		
		if(this.collectedOrbsColor.containsKey(colorEnum.name()))
		{
			this.collectedOrbsColor.put(colorEnum.name(), (long) (this.collectedOrbsColor.get(colorEnum.name()) + (enemyScore * this.modifier)));
		}
		else
		{
			this.collectedOrbsColor.put(colorEnum.name(), 1l);
		}
		
		totalKilled ++;
		if(totalKilled >= 10000)
		{
			firstwing.platformInterface.unlockAchievement("CgkIhpLNkp8BEAIQAw");
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
	
	public void resetScore(boolean checkHighscore)
	{
		if(checkHighscore)
		{
			if(getHighScore(levelID) < currentScore)
			{
				setHighScore(levelID, currentScore);
			
				Iterator<Entry<String, Long>> it = collectedOrbsColor.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry<String, Long> pairs = (Entry<String, Long>)it.next();
					prefs.putLong(pairs.getKey(), prefs.getLong(pairs.getKey()) + pairs.getValue());
					System.out.println(pairs.getKey() + " = " + prefs.getLong(pairs.getKey()));
					it.remove();
				}
			}
			prefs.putLong("enemies.total", totalKilled);
		    prefs.flush();
		}
	    currentColor = ColorEnum.none;
		currentScore = 0;
		modifier = 1f;
		comboOrbs = 0;
	}
	
	public void checkStars(long starOne, long starTwo)
	{
		int stars = 0;
		
		if(trophy)
		{
			stars++;
		}
		
		if(starTwo < getScore())
		{
			stars ++;
		}
		
		if(starOne < getScore())
		{
			stars++;
		}
		
		if(getStars(levelID) < stars)
		{
			FirstWing.stats.setStars(levelID, stars);
		}
		
		if(FirstWing.stats.getStars(levelID) > 0)
		{
			setUnlockedLevels(levelID+1);
		}
	}
	
	public int getStars(int levelID)
	{
		return prefs.getInteger("levelStars" + levelID, 0);
	}
	
	public void setStars(int levelID, int stars)
	{
		prefs.putInteger("levelStars" + levelID, stars);
		prefs.flush();
	}
	
	public void changeLevel(int levelID)
	{
		this.levelID = levelID;
	}

	public long getHighScore(int levelID) {
		return this.prefs.getLong("highscore" + levelID, 0l);
	}

	public void setHighScore(int levelID, long highScore) {
		//Store highscore locally
		prefs.putLong("highscore" + levelID, currentScore);
		prefs.flush();
		
		if(firstwing.platformInterface.getSignedIn())
		{
			//Submit total
			firstwing.platformInterface.submitScore(highScore);
			
			//Submit level
			firstwing.platformInterface.submitScore(getLeaderboardID(levelID) ,highScore);
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
	
	public boolean getTrophy()
	{
		return trophy;
	}
	
	public void setTrophy(boolean trophy)
	{
		this.trophy = trophy;
	}
	
	public long getUnlockedLevels()
	{
		return prefs.getLong("unlocked", 1);
	}
	
	public void setUnlockedLevels(long unlocked)
	{
		if(getUnlockedLevels() < unlocked)
		{
			prefs.putLong("unlocked", unlocked);
			prefs.flush();
		}
	}
	
	public String getLeaderboardID(int level)
	{
		switch (level) {
		case 1:
			return "CgkIhpLNkp8BEAIQCg";
		case 2:
			return "CgkIhpLNkp8BEAIQCw";
		case 3:
			return "CgkIhpLNkp8BEAIQDA";
		case 4:
			return "CgkIhpLNkp8BEAIQDQ";
		case 5:
			return "CgkIhpLNkp8BEAIQDg";
		case 6:
			return "CgkIhpLNkp8BEAIQDw";
		case 7:
			return "CgkIhpLNkp8BEAIQEA";
		case 8:
			return "CgkIhpLNkp8BEAIQEQ";
		case 9:
			return "CgkIhpLNkp8BEAIQEg";
		default:
			return "CgkIhpLNkp8BEAIQAQ";
		}
	}
}
