package com.gamegear.firstwing;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.gamegear.firstwing.levels.json.LevelProperties.ColorEnum;

public class TextureMgr {
	
	private static TextureAtlas dynAtlas /*= new TextureAtlas(Gdx.files.internal("textures/dyntextures.atlas"))*/;
	private static TextureAtlas staAtlas /*= new TextureAtlas(Gdx.files.internal("textures/statextures.atlas"))*/;
	private static HashMap<String, TextureRegion> textureRegions = new HashMap<String, TextureRegion>();
	private static TextureAtlas staticAtlas;
	private static HashMap<String, TextureRegion> staticTexturesRegions = new HashMap<String, TextureRegion>();
	private static HashMap<String, Animation> animations = new HashMap<String, Animation>();
	
	public static void clearTextures(){
		if(staticAtlas != null){
			staticAtlas.dispose();
			staticAtlas = null;
		}
		
		if(staticTexturesRegions != null){
			staticTexturesRegions.clear();
		}
	}
	
	public static void initiate(){
		dynAtlas = new TextureAtlas(Gdx.files.internal("textures/dyntextures.atlas"));
		staAtlas = new TextureAtlas(Gdx.files.internal("textures/other/textures.atlas"));
		textureRegions = new HashMap<String, TextureRegion>();
	}
	
	public static void initiateAtlas(ColorEnum color){
		staticAtlas = new TextureAtlas(Gdx.files.internal("textures/" + color.toString() + "/textures.atlas"));
	}
	
	public static TextureRegion getTexture(String name, boolean staticTexture){
		TextureRegion tr = textureRegions.get(name);
		if(tr == null){
			tr = staticTexture ? staAtlas.findRegion(name) : dynAtlas.findRegion(name);
			textureRegions.put(name, tr);
		}

		return tr;
	}
	
	public static TextureRegion getStaticTexture(String name){
		TextureRegion tr = staticTexturesRegions.get(name);
		if(tr == null){
			tr = staticAtlas.findRegion(name);
			staticTexturesRegions.put(name, tr);
		}
		
		return tr;
	}
	
	public static Animation getAnimation(String name, int frames, float duration, boolean staticTexture){
		Animation ani = animations.get(name);
		if(ani == null){
			TextureRegion[] deathFrames = new TextureRegion[frames];
			for(int i = 0; i < frames; i++){
				deathFrames[i] = getTexture(name + "-death" + i, staticTexture);
			}
			
			ani = new Animation(duration, deathFrames);
			animations.put(name, ani);
		}
		
		return ani;
	}
}
