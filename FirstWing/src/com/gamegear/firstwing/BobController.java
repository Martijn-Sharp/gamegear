package com.gamegear.firstwing;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.gamegear.firstwing.actors.Bob;
import com.gamegear.firstwing.BobController;

public class BobController implements GestureListener, InputProcessor {


	private Bob bob;
	
	public int width;
	public int height;
	
	public int dpadPointer = -1;
	public float dpadX, dpadY = 0;
	
	public BobController(Bob bob, int width, int height) {
		this.bob = bob;
		this.width = width;
		this.height = height;
	}
	
	/** The main update method **/
	public void update(float delta) {
		// simply updates the state time
		bob.update(delta);
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		// TODO Auto-generated method stub
		Gdx.app.log("GestureDetectorTest", "Long Press");
		System.out.println("GestureDetectorTest");
		bob.getBody().setAngularVelocity(0);
		return true;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		// TODO Auto-generated method stub
		if(velocityX > 1000 || velocityY > 1000)
		{
			Gdx.app.log("GestureDetectorTest", "Fling x: " + velocityX + " y:" + velocityY);
			System.out.println("GestureDetectorTest");
			bob.getBody().setAngularVelocity(-10);
			return true;
		}
		else if(velocityX < -1000 || velocityY < -1000)
		{
			Gdx.app.log("GestureDetectorTest", "Fling x: " + velocityX + " y:" + velocityY);
			System.out.println("GestureDetectorTest");
			bob.getBody().setAngularVelocity(10);
			return true;
		}
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
			Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		if (x < width / 3 && y > height - (height/3)) {
			dpadPointer = pointer;
			dpadX = x;
			dpadY = y;
			Gdx.app.log("Touch", "DPAD x: " + x + " y:" + y);
		}
		else
		{
			Gdx.app.log("Touch", "Not DPAD x: " + x + " y:" + y);
		}
		
		return false;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		if (!Gdx.app.getType().equals(ApplicationType.Android)){
			return false;
		}
		
		return false;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		if (!Gdx.app.getType().equals(ApplicationType.Android)){
			return false;
		}
		
		if(pointer == dpadPointer)
		{
			dpadPointer = -1;
			return true;
		}
		
		return false;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		
		if(dpadPointer == pointer)
		{
			float linImpulseX = -(dpadX - x) / 30;
			float linImpulseY = (dpadY - y) / 30;
		
			bob.getBody().setLinearVelocity(linImpulseX, linImpulseY);
			Gdx.app.log("Dragging", "Drag x: " + x + " y:" + y + " pointer:" + pointer + " linearImpulse x:" + linImpulseX + " y:" + linImpulseY);
			return false;
		}
		//body.applyLinearImpulse(linImpulseX, linImpulseY, body.getPosition().x, body.getPosition().y);
		
		return false;
	}

	public boolean touchMoved(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}
}