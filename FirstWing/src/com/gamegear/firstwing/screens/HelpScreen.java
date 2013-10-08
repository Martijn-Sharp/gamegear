package com.gamegear.firstwing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.gamegear.firstwing.FirstWing;

public class HelpScreen extends MenuScreen{
    
private FirstWing firstwing;
private Texture helpTexture;
private int level;

public HelpScreen(FirstWing firstwing, int level) {
		super(firstwing);
		this.firstwing = firstwing;
		this.level = level;

		helpTexture = new Texture(
				Gdx.files.internal("images/menu/helpscreen-512x512.png"));
	}

	@Override
	public void show() {
		super.show();

		Table table = super.getTable();
		table.getColor().a = 0;
		table.addAction(Actions.fadeIn(0.5f));

		Image helpImage = new Image(helpTexture);

		helpImage.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				if (level != -1) {
					if(!firstwing.gameScreen.isLoaded())
					{
						firstwing.gameScreen.load(level);
						firstwing.setScreen(firstwing.gameScreen);
					}
					else
					{
						firstwing.gameScreen.loadLevel(level);
						firstwing.setScreen(firstwing.gameScreen);
					}
				} else {
					firstwing.setScreen(new MainMenu(firstwing));
				}
			}
		});

		// Controls
		final Label helpLabel = new Label("Don't show again", getSkin());
		final CheckBox helpEnable = new CheckBox("", getSkin());
		helpEnable.setChecked(!FirstWing.options.helpEnabled());

		helpEnable.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				boolean b = helpEnable.isChecked();
				FirstWing.options.setHelp(!b);
				FirstWing.options.flush();
			}
		});

		helpEnable.getCells().get(0)
				.size(14 * Gdx.graphics.getDensity() * 1.5f);

		// Layout
		table.add(helpImage).spaceBottom(10).colspan(2);
		table.row();
		table.add(helpLabel).align(Align.right).padLeft(20).spaceRight(10f);
		table.add(helpEnable).align(Align.left).padRight(20).fill();
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		Table.drawDebug(this.stage);
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
		helpTexture.dispose();
	}

}
