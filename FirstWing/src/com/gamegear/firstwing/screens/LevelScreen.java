package com.gamegear.firstwing.screens;

import java.util.Collections;
import java.util.LinkedList;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.gamegear.firstwing.FirstWing;

public class LevelScreen extends MenuScreen {

	FirstWing firstwing;
	final LinkedList<TextButton> levelButtons = new LinkedList<TextButton>();

	public LevelScreen(FirstWing firstwing) {
		super(firstwing);
		this.firstwing = firstwing;
	}

	@Override
	public void show() {
		super.show();

		Table table = super.getTable();
		table.getColor().a = 0;
		table.addAction(Actions.fadeIn(0.5f));
		
		FileHandle dirHandle;
		if (Gdx.app.getType() == ApplicationType.Android) {
			  dirHandle = Gdx.files.internal("levels");
		} else {
			  dirHandle = Gdx.files.internal("./bin/levels");
		}
		
		LinkedList<String> fileDirectory = new LinkedList<String>();

		for (FileHandle entry: dirHandle.list()) {
			fileDirectory.add(entry.nameWithoutExtension());
		}
		
		Collections.sort(fileDirectory);
		
		for(String str : fileDirectory)
		{
			final int name = Integer.parseInt(str);
			// Add button for each level
			levelButtons.add(new TextButton("Level " + str, getSkin()));
			levelButtons.getLast().addListener(new ClickListener() {
				public void clicked(InputEvent event, float x, float y) {
					Gdx.app.log("Menu", "Clicked " + name);
					firstwing.setScreen(new GameScreen(firstwing, name));
				}
			});
		}

		// Back
		TextButton backButton = new TextButton("Back", getSkin());
		backButton.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				firstwing.setScreen(new MainMenu(firstwing));
			}
		});

		// Layout
		table.add("Level Select").spaceBottom(15.0f).center();
		table.row();
		
		
		int i = 0;
		for(TextButton textButton : levelButtons)
		{
			table.add(textButton).fill().uniform().spaceBottom(10);
			i++;
			if(i % 3 == 0){
				table.row();
			}
		}
		table.row();
		table.add(backButton).fill().uniform().spaceBottom(10);

	}

	@Override
	public void render(float delta) {
		super.render(delta);

	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	protected void handleReturn() {
		// TODO Auto-generated method stub
		
	}
}