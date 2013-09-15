package com.gamegear.firstwing.levels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.type.TypeReference;

public class JSONLoader {
	
	private Map<String, Tile> level;
	
	public JSONLoader(String mapPath)
	{
		String jsonFile = "";
		try {
			jsonFile = readFile(mapPath);
		} catch (IOException e) {
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
	
	private String readFile( String file ) throws IOException {
	    BufferedReader reader = new BufferedReader( new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	    String         ls = System.getProperty("line.separator");

	    while( ( line = reader.readLine() ) != null ) {
	        stringBuilder.append( line );
	        stringBuilder.append( ls );
	    }

	    String s = stringBuilder.toString();
	    reader.close();
	    return s;
	}
}
