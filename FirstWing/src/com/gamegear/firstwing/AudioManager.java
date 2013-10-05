package com.gamegear.firstwing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class AudioManager {
	public HashMap<String, Sound> sounds;
	public LinkedList<Music> music;
	
	public int currentlyPlaying;
	public boolean enabled = false;
	
	public AudioManager()
	{
		sounds = new HashMap<String, Sound>();
		music = new LinkedList<Music>();
		
		loadSounds();
		loadMusic();
		
		currentlyPlaying = 0;
	}
	
	public void loadSounds()
	{
		sounds.put("explosion", Gdx.audio.newSound(Gdx.files.internal("sounds/sfx/explosion.mp3")));
		sounds.put("laser", Gdx.audio.newSound(Gdx.files.internal("sounds/sfx/laser.mp3")));
	}
	
	public void loadMusic()
	{
		music.add(Gdx.audio.newMusic(Gdx.files.internal("sounds/TeleportPro.ogg")));
		music.add(Gdx.audio.newMusic(Gdx.files.internal("sounds/BergsmatarenLever.ogg")));
	}
	
	public void enableMusic()
	{
		if(FirstWing.options.musicEnabled())
		{
			music.get(currentlyPlaying).setVolume(FirstWing.options.getVolume());
			music.get(currentlyPlaying).play();
			enabled = true;
		}
	}
	
	public void disableMusic()
	{
		music.get(currentlyPlaying).stop();
		enabled = false;
	}
	
	public boolean isEnabled()
	{
		return enabled;
	}
	
	public void handleMusic()
	{
		//If song is finished
		if(!music.get(currentlyPlaying).isPlaying() && FirstWing.options.musicEnabled() && enabled)
		{
			if(music.size() > currentlyPlaying + 1)
			{
				currentlyPlaying++;
			}
			else
			{
				currentlyPlaying = 0;
			}
			music.get(currentlyPlaying).setVolume(FirstWing.options.getVolume());
			music.get(currentlyPlaying).play();
		}
	}
	
	public void dispose()
	{
		Iterator<Entry<String, Sound>> it = sounds.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry<String, Sound> pairs = (Map.Entry<String, Sound>)it.next();
	        pairs.getValue().dispose();
	        it.remove();
	    }
	    sounds.clear();
	    
	    for(Music m : music)
	    {
	    	m.dispose();
	    }
	    music.clear();
	}
}
