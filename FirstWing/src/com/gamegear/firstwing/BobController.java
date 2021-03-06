package com.gamegear.firstwing;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.gamegear.firstwing.actors.Bob;
import com.gamegear.firstwing.screens.GameScreen;
import com.gamegear.firstwing.screens.GameScreen.GameState;
import com.gamegear.firstwing.BobController;

public class BobController implements GestureListener, InputProcessor {


	private GameScreen screen;
	private Bob bob;
	OrthographicCamera cam;
	
	///////////////////////
	/// Mouse Collision ///
	///////////////////////
	protected Body hitBody = null;
    protected Body groundBody;
    protected Vector2 target = new Vector2();
    
	public int width;
	public int height;
	
	public int dpadPointer = -1;
	public int dpadCenterX, dpadCenterY = -1;
	public int dpadX, dpadY = -1;
	
	//Bob impulse power
	public float linImpulseX = 0;
	public float linImpulseY = 0;

	
	//Gesture tracker
	public boolean gestureTracking = false;
	public long flingDelay = 150 * 1000000l;
	
	public VelocityTracker tracker = new VelocityTracker();
	
	public BobController(GameScreen screen, int width, int height) {
		this.screen = screen;
		this.bob = screen.level.getPlayer();
		this.width = width;
		this.height = height;
		this.cam = screen.renderer.getCam();
		
		BodyDef bodyDef = new BodyDef();
        groundBody = screen.world.createBody(bodyDef);
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
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
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
		//Gdx.app.log("Zoom", "Distance: " + distance);
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
//		if (x < width / 3 && y > height - (height/3)) {
//		dpadPointer = pointer;
//		dpadCenterX = (int) x;
//		dpadCenterY = (int) y;
//		Gdx.app.log("Touch", "DPAD x: " + x + " y:" + y + " pointer:" + pointer);
//		}
//		else
//		{
//			Gdx.app.log("Touch", "Not DPAD x: " + x + " y:" + y + " pointer:" + pointer);
//		}
		
		return false;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
//		if (!Gdx.app.getType().equals(ApplicationType.Android)){
//			return false;
//		}
		
		//if (x < width / 4 && y > height - (height/3)) {
		dpadPointer = pointer;
		dpadCenterX = x;
		dpadCenterY = y;
		dpadX = x;
		dpadY = y;
		Gdx.app.log("Touch", "DPAD x: " + x + " y:" + y + " pointer:" + pointer);
		
		if(this.screen.getCurrentState() == GameState.Begin){
			this.screen.setCurrentState(GameState.Running);
		}
		
		//checkCollision(x, y, false);
		
		return true;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
//		if (!Gdx.app.getType().equals(ApplicationType.Android)){
//			return false;
//		}
		
		if(pointer == dpadPointer)
		{
			dpadPointer = -1;
			dpadCenterX = -1;
			dpadCenterY = -1;
			dpadX = -1;
			dpadY = -1;
			
			linImpulseX = 0;
			linImpulseY = 0;

			return false;
		}
		
//		if (mouseJoint != null) {
//            screen.world.world.destroyJoint(mouseJoint);
//            mouseJoint = null;
//		}
		
		Gdx.app.log("Touch", "Touch up pointer:" + pointer);
		
		return true;
	}
	
	public int getPointerCount()
	{
		int activeTouch = 0;
		for (int i = 0; i < 20; i++) {
			if (Gdx.app.getInput().isTouched(i)) 
			{
				activeTouch++;
			}
		}
		return activeTouch;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
//		if(getPointerCount() >= 2)
//		{
//			//CURRENTLY SUPPORTS 2 FINGERS
//			int gesturePointer;
//			if(dpadPointer == 0)
//			{
//				gesturePointer = 1;
//			}
//			else
//			{
//				gesturePointer = 0;
//			}
//			
//			int secondX = Gdx.input.getX(gesturePointer);
//			int secondY = Gdx.input.getY(gesturePointer);
//			if(!gestureTracking && Gdx.input.isTouched(gesturePointer))
//			{
//				tracker.start(secondX, secondY, Gdx.input.getCurrentEventTime());
//				Gdx.app.log("Fling", "Fling start x:" + secondX + " y:" + secondY);
//				gestureTracking = true;
//				return false;
//			}
//			else if (gestureTracking && Gdx.input.isTouched(gesturePointer) && Gdx.input.getCurrentEventTime() - tracker.lastTime <= flingDelay)
//			{
//				tracker.update(secondX, secondY, Gdx.input.getCurrentEventTime());
//				//Gdx.app.log("Fling", "Fling update  x:" + secondX + " y:" + secondY);
//				
//				//Check collisions with all Actors
//				//checkCollision(x, y, false);
//				
//				return false;
//			}
//			else if (gestureTracking && Gdx.input.isTouched(gesturePointer) && Gdx.input.getCurrentEventTime() - tracker.lastTime > flingDelay)
//			{
//				//tracker.update(secondX, secondY, Gdx.input.getCurrentEventTime());
//				gestureTracking = false;
//				//Gdx.app.log("Fling", "Fling end  xvel:" + tracker.getVelocityX() + " yvel:" + tracker.getVelocityY());
//				fling(tracker.getVelocityX(), tracker.getVelocityY(), 0);
//				
//				return false;
//			}
//			
//		}
		
		if(dpadPointer == pointer)
		{
			dpadX = x;
			dpadY = y;

			linImpulseY = Gdx.graphics.getDeltaTime()
					* ((dpadCenterY - y) * (1 * (FirstWing.options
							.getSensitivity() + 1)));

			// Check if going out of map
			if (screen.renderer.cameraX - 4f <= screen.level.getPlayer()
					.getPosition().x || -(dpadCenterX - x) > 0) {
			} else {
				linImpulseX = 0;
				return false;
			}
			if (screen.renderer.cameraX + 4f >= screen.level.getPlayer()
					.getPosition().x || -(dpadCenterX - x) < 0) {
			} else {
				linImpulseX = 0;
				return false;
			}

			linImpulseX = Gdx.graphics.getDeltaTime()
					* (-(dpadCenterX - x) * (1 * (FirstWing.options
							.getSensitivity() + 1)));

		}
		return false;
	}

	public boolean touchMoved(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		Gdx.app.log("Scroll", "Amount: " + amount);
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.BACK || keycode == Keys.ESCAPE){
			screen.handleReturn();
	    }
	    return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public int getDpadCenterX()
	{
		return dpadCenterX;
	}
	
	public int getDpadCenterY()
	{
		return height - dpadCenterY;
	}
	
	public int getDpadX()
	{
		return dpadX;
	}
	
	public int getDpadY()
	{
		return height - dpadY;
	}
	
	static class VelocityTracker {
		int sampleSize = 10;
		float lastX, lastY;
		float deltaX, deltaY;
		long lastTime;
		int numSamples;
		float[] meanX = new float[sampleSize];
		float[] meanY = new float[sampleSize];
		long[] meanTime = new long[sampleSize];

		public void start (float x, float y, long timeStamp) {
			lastX = x;
			lastY = y;
			deltaX = 0;
			deltaY = 0;
			numSamples = 0;
			for (int i = 0; i < sampleSize; i++) {
				meanX[i] = 0;
				meanY[i] = 0;
				meanTime[i] = 0;
			}
			lastTime = timeStamp;
		}

		public void update (float x, float y, long timeStamp) {
			long currTime = timeStamp;
			deltaX = x - lastX;
			deltaY = y - lastY;
			lastX = x;
			lastY = y;
			long deltaTime = currTime - lastTime;
			lastTime = currTime;
			int index = numSamples % sampleSize;
			meanX[index] = deltaX;
			meanY[index] = deltaY;
			meanTime[index] = deltaTime;
			numSamples++;
		}

		public float getVelocityX () {
			float meanX = getAverage(this.meanX, numSamples);
			float meanTime = getAverage(this.meanTime, numSamples) / 1000000000.0f;
			if (meanTime == 0) return 0;
			return meanX / meanTime;
		}

		public float getVelocityY () {
			float meanY = getAverage(this.meanY, numSamples);
			float meanTime = getAverage(this.meanTime, numSamples) / 1000000000.0f;
			if (meanTime == 0) return 0;
			return meanY / meanTime;
		}

		private float getAverage (float[] values, int numSamples) {
			numSamples = Math.min(sampleSize, numSamples);
			float sum = 0;
			for (int i = 0; i < numSamples; i++) {
				sum += values[i];
			}
			return sum / numSamples;
		}

		private long getAverage (long[] values, int numSamples) {
			numSamples = Math.min(sampleSize, numSamples);
			long sum = 0;
			for (int i = 0; i < numSamples; i++) {
				sum += values[i];
			}
			if (numSamples == 0) return 0;
			return sum / numSamples;
		}
	}
}