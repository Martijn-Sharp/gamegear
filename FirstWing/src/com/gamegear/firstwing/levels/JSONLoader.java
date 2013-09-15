package com.gamegear.firstwing.levels;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.files.FileHandle;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.type.TypeReference;

public class JSONLoader {
	
	private Map<String, Tile> level;
	
	public JSONLoader(FileHandle mapHandler)
	{
		String jsonFile = "";
		try {
			jsonFile = mapHandler.readString();
		} catch (Exception e) {
			System.out.println("File didn't load");
		}
		
		level = new HashMap<String,Tile>();
		ObjectMapper mapper = new ObjectMapper();
	 
		try {
	 
			//convert JSON string to Map
			level = mapper.readValue(jsonFile, 
			    new TypeReference<HashMap<String,Tile>>(){});
	 
			System.out.println(level);
	 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Map<String, Tile> getLevel()
	{
		return level;
	}
}
