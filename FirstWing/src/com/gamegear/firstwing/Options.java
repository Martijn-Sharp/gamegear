package com.gamegear.firstwing;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class Options {
    
    // Graphics
    public static final String WIDTH = "window.width";
    public static final String HEIGHT = "window.height";
    public static final String VSYNC = "vSync.enabled";
    public static final String FULLSCREEN = "fullscreen.enabled";

    // Audio
    public static final String MUSIC = "music.enabled";
    public static final String VOLUME = "music.volume";
    public static final String SFX = "sfx.enabled";

    protected Preferences getPrefs() {
            return Gdx.app.getPreferences("dungeon-data");
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

    public boolean vSyncEnabled() {
            return getPrefs().getBoolean(VSYNC, true);
    }

    public void setVSync(boolean value) {
            getPrefs().putBoolean(VSYNC, value);
    }

    public boolean getFullscreen() {
            return getPrefs().getBoolean(FULLSCREEN, false);
    }

    public void setFullscreen(boolean value) {
            getPrefs().putBoolean(FULLSCREEN, value);
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

}