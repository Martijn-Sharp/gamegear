package com.gamegear.firstwing;

import com.badlogic.gdx.Gdx;
import com.gamegear.firstwing.actors.json.ActorProperties;
import com.gamegear.firstwing.actors.json.ActorFile;
import com.gamegear.firstwing.actors.json.DynamicActor;
import com.gamegear.firstwing.actors.json.StaticActor;
import com.gamegear.firstwing.levels.JSONLoader;

public class ActorMgr {
	
	private static ActorFile file;
	
	@SuppressWarnings("unchecked")
	public static <T extends ActorProperties> T getProperties(String name, T type){
		if(file == null){
			file = LoadActorFile();
		}
		
		if(type instanceof StaticActor){
			if(file.StaticActors != null){
				return (T) file.StaticActors.get(name);
			}
		} else if (type instanceof DynamicActor){
			if(file.DynamicActors != null){
				return (T) file.DynamicActors.get(name);
			}
		}
		
		return null;
	}
	
	private static ActorFile LoadActorFile(){
		return new JSONLoader().getActorFile(Gdx.files.internal("actors.dat"));
	}
}
