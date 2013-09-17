package com.gamegear.firstwing.levels;

import com.badlogic.gdx.files.FileHandle;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.type.TypeReference;

public class JSONLoader {
	
	private LoadedLevel level;
	
	public JSONLoader(FileHandle mapHandler)
	{
		String jsonFile = "";
		try {
			jsonFile = mapHandler.readString();
		} catch (Exception e) {
			System.out.println("File didn't load");
		}
		
		ObjectMapper mapper = new ObjectMapper();
	 
		try {
	 
			//convert JSON string to Map
			level = mapper.readValue(jsonFile, new TypeReference<LoadedLevel>(){});
	 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public LoadedLevel getLevel()
	{
		return level;
	}
}
