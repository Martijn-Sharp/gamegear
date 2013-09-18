package com.gamegear.firstwing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.gamegear.firstwing.BobController;
import com.gamegear.firstwing.FwWorld;
import com.gamegear.firstwing.WorldRenderer;

public class GameScreen implements Screen {

	private FwWorld 		world;
	private WorldRenderer 	renderer;
	private BobController	controller;
	GestureDetector gestureDetector;
	Texture interfaceTexture;
	SpriteBatch interfaceBatch;
	
	
	InputMultiplexer im;
	
	private int width, height;
	
	@Override
	public void show() {
		
		//Rendering
		world = new FwWorld();
		renderer = new WorldRenderer(world, false);
		
		interfaceTexture = new Texture(Gdx.files.internal("images/dpad.png"));
		interfaceBatch = new SpriteBatch();
		
		//Input
		controller = new BobController(world.getBob(), width, height);
		gestureDetector = new GestureDetector(20, 0.5f, 1, 0.15f, controller);
		im = new InputMultiplexer(gestureDetector, controller); // Order matters here!
		Gdx.input.setInputProcessor(im);
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		//Update input
		controller.update(delta);
		
		//Render frame
		renderer.render();
		
		//Render interface
		
		if(controller.getDpadCenterX() > 0)
		{
			interfaceBatch.begin();
			interfaceBatch.draw(interfaceTexture, controller.getDpadCenterX() - interfaceTexture.getWidth()/4, controller.getDpadCenterY() - interfaceTexture.getHeight()/4, interfaceTexture.getWidth()/2, interfaceTexture.getHeight()/2);
			interfaceBatch.draw(interfaceTexture, controller.getDpadX() - interfaceTexture.getWidth()/2, controller.getDpadY() - interfaceTexture.getHeight()/2, interfaceTexture.getWidth(), interfaceTexture.getHeight());
			interfaceBatch.end();
			//Gdx.app.log("Interface", "Dpad center  x:" + controller.getDpadCenterX() + " y:" + controller.getDpadCenterY() + " current x:" + controller.getDpadX() + " y:" + controller.getDpadY());
		}
	}
	
	@Override
	public void resize(int width, int height) {
		renderer.setSize(width, height);
		this.width = width;
		this.height = height;
		controller.width = width;
		controller.height = height;
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
	}

	@Override
	public void dispose() {
		Gdx.input.setInputProcessor(null);
	}
}