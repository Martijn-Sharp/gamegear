package com.gamegear.firstwing.levels;

import com.badlogic.gdx.files.FileHandle;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.gamegear.firstwing.actors.json.ActorFile;

public class JSONLoader  {
	
	public com.gamegear.firstwing.levels.json.Level getLevel(FileHandle mapHandler)
	{
		com.gamegear.firstwing.levels.json.Level level = null;
		String jsonFile = "";
		try {
			jsonFile = mapHandler.readString();
		} catch (Exception e) {
			System.out.println("File didn't load");
		}
		
		ObjectMapper mapper = new ObjectMapper();
	 
		try {
	 
			//convert JSON string to Map
			level = mapper.readValue(jsonFile, new TypeReference<com.gamegear.firstwing.levels.json.Level>(){});
	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return level;
	}
	
	public ActorFile getActorFile(FileHandle mapHandler)
	{
		ActorFile level = null;
		String jsonFile = "";
		try {
			jsonFile = mapHandler.readString();
		} catch (Exception e) {
			System.out.println("File didn't load");
		}
		
		ObjectMapper mapper = new ObjectMapper();
	 
		try {
	 
			//convert JSON string to Map
			level = mapper.readValue(jsonFile, new TypeReference<ActorFile>(){});
	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return level;
	}
}
