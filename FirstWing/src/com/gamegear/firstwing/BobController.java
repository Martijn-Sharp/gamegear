package com.gamegear.firstwing;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.gamegear.firstwing.actors.Bob;
import com.gamegear.firstwing.BobController;

public class BobController implements GestureListener, InputProcessor {

	
	enum State {
		LEFT, RIGHT, FIRE, UP, DOWN
	}

	private static final float ACCELERATION 	= 4f;
	
	private Bob bob;
	Body body;
	
	public int width;
	public int height;
	
	public int dpadPointer = -1;
	public float dpadX, dpadY = 0;
	
	static Map<State, Boolean> state = new HashMap<BobController.State, Boolean>();
	static {
		state.put(State.LEFT, false);
		state.put(State.RIGHT, false);
		state.put(State.FIRE, false);
		state.put(State.UP, false);
		state.put(State.DOWN, false);
	};
	
	public BobController(Bob bob, int width, int height) {
		this.bob = bob;
		this.width = width;
		this.height = height;
	}

	// ** Key presses and touches **************** //
	
	public void leftPressed() {
		state.get(state.put(State.LEFT, true));
	}
	
	public void rightPressed() {
		state.get(state.put(State.RIGHT, true));
	}
	
	public void firePressed() {
		state.get(state.put(State.FIRE, true));
	}
	
	public void upPressed(){
		state.get(state.put(State.UP, true));
	}
	
	public void downPressed(){
		state.get(state.put(State.DOWN, true));
	}
	
	public void leftReleased() {
		state.get(state.put(State.LEFT, false));
	}
	
	public void rightReleased() {
		state.get(state.put(State.RIGHT, false));
	}
	
	public void fireReleased() {
		state.get(state.put(State.FIRE, false));
	}
	
	public void upReleased() {
		state.get(state.put(State.UP, false));
	}
	
	public void downReleased() {
		state.get(state.put(State.DOWN, false));
	}
	
	/** The main update method **/
	public void update(float delta) {
		// Processing the input - setting the states of Bob
		body = bob.getBody();
		processInput();
		
		// simply updates the state time
		bob.update(delta);
	}

	/** Change Bob's state and parameters based on input controls **/
	private boolean processInput() {		
//		if (state.get(State.LEFT)) {
//			// left is pressed
//			bob.setState(Bob.State.BREAKING);
//			if(body.getLinearVelocity().x > -ACCELERATION){
//				body.applyLinearImpulse(-ACCELERATION, 0, body.getPosition().x, body.getPosition().y);
//			}
//		} else if (state.get(State.RIGHT)) {
//			// left is pressed
//			bob.setState(Bob.State.ACCELERATING);
//			if(body.getLinearVelocity().x < ACCELERATION){
//				body.applyLinearImpulse(ACCELERATION, 0, body.getPosition().x, body.getPosition().y);
//			}
//		} else {
//			bob.setState(Bob.State.IDLE);
//			body.setLinearVelocity(0, body.getLinearVelocity().y);
//		}
//		
//		if (state.get(State.UP)) {
//			// UP is pressed
//			if(body.getLinearVelocity().y < ACCELERATION){
//				body.applyLinearImpulse(0, ACCELERATION, body.getPosition().x, body.getPosition().y);
//			}
//		} else if (state.get(State.DOWN)) {
//			// DOWN is pressed
//			if(body.getLinearVelocity().y > -ACCELERATION){
//				body.applyLinearImpulse(0, -ACCELERATION, body.getPosition().x, body.getPosition().y);
//			}
//		} else {
//			body.setLinearVelocity(body.getLinearVelocity().x, 0);
//		}
		
		return false;
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
		body.setAngularVelocity(0);
		return true;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		// TODO Auto-generated method stub
		if(velocityX > 1000 || velocityY > 1000)
		{
			Gdx.app.log("GestureDetectorTest", "Fling x: " + velocityX + " y:" + velocityY);
			System.out.println("GestureDetectorTest");
			body.setAngularVelocity(-10);
			return true;
		}
		else if(velocityX < -1000 || velocityY < -1000)
		{
			Gdx.app.log("GestureDetectorTest", "Fling x: " + velocityX + " y:" + velocityY);
			System.out.println("GestureDetectorTest");
			body.setAngularVelocity(10);
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
	public boolean keyDown(int keycode) {
		if (keycode == Keys.LEFT)
			leftPressed();
		if (keycode == Keys.RIGHT)
			rightPressed();
		if (keycode == Keys.X)
			firePressed();
		if (keycode == Keys.UP)
			upPressed();
		if (keycode == Keys.DOWN)
			downPressed();
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.LEFT)
			leftReleased();
		if (keycode == Keys.RIGHT)
			rightReleased();
		if (keycode == Keys.X)
			fireReleased();
		if (keycode == Keys.UP)
			upReleased();
		if (keycode == Keys.DOWN)
			downReleased();
		return true;
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
		
//		if (x < width / 2) {
//			leftPressed();
//		}
//		
//		if (x > width / 2) {
//			rightPressed();
//		}
//		
//		if (y < height / 2){
//			upPressed();
//		}
//		
//		if (y > height / 2){
//			downPressed();
//		}
		
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
//		if (x < width / 2 && y > height / 2) {
//			leftReleased();
//		}
//		
//		if (x > width / 2 && y > height / 2) {
//			rightReleased();
//		}
//		
//		if (y < height / 2){
//			upReleased();
//		}
//		
//		if (y > height / 2){
//			downReleased();
//		}
		
		
		
		return false;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		
		if(dpadPointer == pointer)
		{
			float linImpulseX = -(dpadX - x) / 30;
			float linImpulseY = (dpadY - y) / 30;
		
			body.setLinearVelocity(linImpulseX, linImpulseY);
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
	
	
}