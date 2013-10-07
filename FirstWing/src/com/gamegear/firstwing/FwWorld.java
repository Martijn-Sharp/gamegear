package com.gamegear.firstwing;

import java.util.Iterator;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.World;
import com.gamegear.firstwing.actors.*;
import com.gamegear.firstwing.levels.Level;

public class FwWorld {
	
	World world;
	/** Our player controlled hero **/
	Bob bob;
	/** A world has a level through which Bob needs to go through **/
	Level level;
	
	public Bob getBob() {
		return bob;
	}
	
	public Level getLevel() {
		return level;
	}
	
	public World getWorld() {
		return world;
	}

	// --------------------
	public FwWorld(String levelPath) {
		this.createWorld(levelPath);
	}
	
	public void createWorld(String levelPath) {
		if(world != null)
		{
			dispose();
		}
		System.gc();
		this.world = new World(new Vector2(0, 0), true);
		this.level = new Level(this.world, levelPath);
		this.bob = this.level.getPlayer();
	}
	
	public void dispose() {
		world.clearForces();
       
        Iterator<Joint> joints = world.getJoints();
        while (joints.hasNext()) {
            Joint j = joints.next();
            if (j != null) world.destroyJoint(j);
        }
 
        Iterator<Body> bodies = world.getBodies();
        while (bodies.hasNext()) {
            Body b = bodies.next();
            if (b != null) world.destroyBody(b);
        }
        
        level.dispose();
    }
}