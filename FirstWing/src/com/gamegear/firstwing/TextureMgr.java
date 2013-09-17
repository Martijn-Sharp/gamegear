package com.gamegear.firstwing;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureMgr {
	
	private static TextureAtlas dynAtlas = new TextureAtlas(Gdx.files.internal("textures/dyntextures.pack"));
	private static TextureAtlas staAtlas = new TextureAtlas(Gdx.files.internal("textures/statextures.pack"));
	private static HashMap<String, TextureRegion> textureRegions = new HashMap<String, TextureRegion>();
	
	public static TextureRegion getTexture(String name, boolean staticTexture){
		TextureRegion tr = textureRegions.get(name);
		if(tr == null){
			tr = staticTexture ? staAtlas.findRegion(name) : dynAtlas.findRegion(name);
			textureRegions.put(name, tr);
		}
		
		return tr;
	}
}
