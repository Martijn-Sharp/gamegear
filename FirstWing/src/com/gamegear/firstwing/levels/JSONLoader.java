package com.gamegear.firstwing.levels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

public class JSONLoader {
	
	public Map level;
	
	public JSONLoader(String mapPath)
	{
		String jsonFile = "";
		try {
			jsonFile = readFile(mapPath);
			System.out.println(jsonFile);
		} catch (IOException e) {
			System.out.println("Ja dat lukt niet sukkel");
		}
		Object obj=JSONValue.parse(jsonFile);
		JSONArray array=(JSONArray)obj;
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

	    return stringBuilder.toString();
	}
}
