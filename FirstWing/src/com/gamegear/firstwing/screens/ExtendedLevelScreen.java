package com.gamegear.firstwing.screens;

import java.util.Collections;
import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.gamegear.firstwing.FirstWing;

public class ExtendedLevelScreen extends MenuScreen {
	
	FirstWing firstwing;
	
	public ExtendedLevelScreen(FirstWing firstwing) {
		super(firstwing);
		this.firstwing = firstwing;
		load();
	}

	public void show() {	
		super.show();
		super.getTable().clear();
		load();
	}
	
	public void load() {
		Table table = super.getTable();

		FileHandle dirHandle;
		if (Gdx.app.getType() == ApplicationType.Android) {
			dirHandle = Gdx.files.internal("levels");
		} else {
			dirHandle = Gdx.files.internal("./bin/levels");
		}

		LinkedList<String> fileDirectory = new LinkedList<String>();

		for (FileHandle entry : dirHandle.list()) {
			fileDirectory.add(entry.nameWithoutExtension());
		}

		Collections.sort(fileDirectory);

		// Back
		TextButton backButton = new TextButton("Back", getSkin());
		backButton.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				firstwing.setScreen(firstwing.mainScreen);
			}
		});

		PagedScrollPane scroll = new PagedScrollPane();
		scroll.setFlingTime(0.1f);
		scroll.setPageSpacing(25);
		int c = 1;
		boolean finished = false;
		while (!finished) {
			Table levels = new Table().pad(40);
			levels.defaults().pad(10, 25, 10, 25);
			for (int y = 0; y < 3; y++) {
				levels.row();
				for (int x = 0; x < 3; x++) {
					if (fileDirectory.size() < c) {
						finished = true;
						break;
					}
					levels.add(getLevelButton(fileDirectory.get(c - 1)))
							.expand().fill();
					c++;
				}
			}
			scroll.addPage(levels);
		}
		table.add(scroll).expand().fill();
		table.row();
		table.add(backButton).padLeft(20).align(Align.left);
	}

	public void render(float delta) {
		super.render(delta);
	}

	public void resize (int width, int height) {
		super.resize(width, height);
	}

	public void dispose () {
		super.dispose();
	}
	
	/**
	 * Creates a button to represent the level
	 * 
	 * @param level
	 * @return The button to use for the level
	 */
	public Button getLevelButton(String level) {
		Button button = new Button(getSkin());
		ButtonStyle style = button.getStyle();
		style.up = 	style.down = null;
		
		// Create the label to show the level number
		Label label = new Label(level, getSkin());
		label.setFontScale(1f);
		label.setAlignment(Align.center);		
		if(FirstWing.stats.getUnlockedLevels() >= Integer.parseInt(level))
		{
			// Stack the image and the label at the top of our button
			button.stack(new Image(getSkin().getDrawable("top")), label).expand().fill();
			button.addListener(levelClickListener);	
		}
		else
		{
			button.stack(new Image(getSkin().getDrawable("button-disabled")), label).expand().fill();
		}

		// Get stars earned
		int stars = FirstWing.stats.getStars(Integer.parseInt(level));
		Table starTable = new Table();
		starTable.defaults().pad(5);
		if (stars >= 0) {
			for (int star = 0; star < 3; star++) {
				if (stars > star) {
					starTable.add(new Image(getSkin().getDrawable("star-filled"))).width(20).height(20);
				} else {
					starTable.add(new Image(getSkin().getDrawable("star-unfilled"))).width(20).height(20);
				}
			}			
		}
		
		button.row();
		button.add(starTable).height(30);
		
		button.setName(level);
			
		return button;
	}
	
	/**
	 * Handle the click - in real life, we'd go to the level
	 */
	public ClickListener levelClickListener = new ClickListener() {
		@Override
		public void clicked (InputEvent event, float x, float y) {
			System.out.println("Click: " + event.getListenerActor().getName());
			if(FirstWing.options.helpEnabled())
			{
				firstwing.setScreen(new HelpScreen(firstwing, Integer.parseInt(event.getListenerActor().getName())));
			}
			else
			{
				firstwing.setScreen(new GameScreen(firstwing, Integer.parseInt(event.getListenerActor().getName())));
			}
		}
	};

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
}