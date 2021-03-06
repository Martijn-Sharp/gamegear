package com.gamegear.firstwing;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Options {
	
	public static final String PREFS_NAME = "ColorExpress";
	
	// Controls
	public static final String INVERT = "controls.invert.enabled";
	public static final String SENSITIVITY = "controls.sensitivity.enabled";
	
	// Toggles
	public static final String 	HELP 			= "help.enabled";
	public static final String 	PLAYSERVICES	= "play.enabled";
    
    // Graphics
    public static final String WIDTH = "window.width";
    public static final String HEIGHT = "window.height";
    public static final String VSYNC = "vSync.enabled";
    public static final String FULLSCREEN = "fullscreen.enabled";

    // Audio
    public static final String MUSIC = "music.enabled";
    public static final String VOLUME = "music.volume";
    public static final String SFX = "sfx.enabled";
    
    private Preferences preferences;
    
    protected Preferences getPrefs() {
       if(preferences==null){
          preferences = Gdx.app.getPreferences(PREFS_NAME);
       }
       return preferences;
    }

    public void flush() {
            getPrefs().flush();
    }

    public int getWidth() {
            return getPrefs().getInteger(WIDTH, 800);
    }

    public void setWidth(int width) {
            getPrefs().putInteger(WIDTH, width);
    }

    public int getHeight() {
            return getPrefs().getInteger(HEIGHT, 600);
    }

    public void setHeight(int height) {
            getPrefs().putInteger(HEIGHT, height);
    }

    public boolean musicEnabled() {
            return getPrefs().getBoolean(MUSIC, true);
    }

    public void setMusicEnabled(boolean value) {
            getPrefs().putBoolean(MUSIC, value);
    }

    public boolean sfxEnabled() {
            return getPrefs().getBoolean(SFX, true);
    }

    public void setSFX(boolean value) {
            getPrefs().putBoolean(SFX, value);
    }

    public float getVolume() {
            return getPrefs().getFloat(VOLUME, 1.0f);
    }

    public void setVolume(float volume) {
            getPrefs().putFloat(VOLUME, volume);
    }
    
    public boolean invertEnabled() {
        return getPrefs().getBoolean(INVERT, false);
    }

    public void setInvert(boolean value) {
        getPrefs().putBoolean(INVERT, value);
    }
    
    public boolean helpEnabled() {
        return getPrefs().getBoolean(HELP, true);
    }

    public void setHelp(boolean value) {
        getPrefs().putBoolean(HELP, value);
    }
    
    public float getSensitivity() {
        return getPrefs().getFloat(SENSITIVITY, 0.5f);
    }

    public void setSensitivity(float sensitivity) {
        getPrefs().putFloat(SENSITIVITY, sensitivity);
    }
    
    public boolean getPlayServices() {
        return getPrefs().getBoolean(PLAYSERVICES, true);
    }

    public void setPlayServices(boolean value) {
        getPrefs().putBoolean(PLAYSERVICES, value);
        flush();
    }

}