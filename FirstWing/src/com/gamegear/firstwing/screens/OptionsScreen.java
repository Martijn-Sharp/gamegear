package com.gamegear.firstwing.screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.gamegear.firstwing.FirstWing;

public class OptionsScreen extends MenuScreen {
    
    private FirstWing game;
    

    public OptionsScreen(FirstWing game) {
            super(game);
            this.game = game;
    }

    @Override
    public void show() {
    
            super.show();
            
            //Controls
            final Label invertLabel = new Label("Invert Controls:", getSkin());
            final CheckBox invert = new CheckBox("", getSkin());
            invert.setChecked(FirstWing.options.invertEnabled());
            invert.addListener(new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                            boolean b = invert.isChecked();
                            FirstWing.options.setInvert(b);
                            invertLabel.setText("Invert Controls:");
                    }
            });
            
            
            final Label sensLabel = new Label("Sensitivity:", getSkin());
            final Slider sensitivity = new Slider( 0f, 1f, 0.01f, false, getSkin(), "default-horizontal");
            sensitivity.setValue(FirstWing.options.getSensitivity());
            sensitivity.addListener(new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                    			FirstWing.options.setSensitivity(sensitivity.getValue());
                    			sensLabel.setText("Sensitivity:");
                            }
                    });
            

            
            //Audio
            final Label musicLabel = new Label("Music:", getSkin());
            final CheckBox music = new CheckBox("", getSkin());
            music.setChecked(FirstWing.options.musicEnabled());
            music.addListener(new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                            boolean b = music.isChecked();
                            FirstWing.options.setMusicEnabled(b);
                            musicLabel.setText("Music:");
                    }
            });
            
            
            final Label volumeLabel = new Label("Volume:", getSkin());
            final Slider volume = new Slider( 0f, 1f, 0.01f, false, getSkin(), "default-horizontal");
            volume.setValue(FirstWing.options.getVolume());
            volume.addListener(new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                    			FirstWing.options.setVolume(volume.getValue());
                    			volumeLabel.setText("Volume:");
                            }
                    });
            
            // Nav
            
            TextButton back = new TextButton("Back", getSkin());
            back.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                    	game.setScreen(new MainMenu(game));
                    }
            });
            
            TextButton apply = new TextButton("Apply", getSkin());
            apply.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                    	FirstWing.options.flush();
                    	//game.setScreen(new MainMenu(game));
                    	//game.init();
                    }
            });
            
            Table table = super.getTable();
            table.getColor().a = 0;
            table.addAction(Actions.fadeIn(0.5f));
            
            //Add controls to table
            
            table.add("Controls").spaceBottom(15.0f).colspan(2).align(Align.left);
            table.row().expand();
            table.add(invertLabel).uniform().align(Align.left).padLeft(20);
            table.add(invert).uniform().spaceBottom(5).align(Align.left);
            table.row().expand();
            table.add(sensLabel).uniform().align(Align.left).padLeft(20);
            table.add(sensitivity).uniform().align(Align.left);
            table.row().expand();
            
            //Add audio to table
            table.add("Audio").spaceBottom(15.0f).colspan(2).align(Align.left);
            table.row().expand();
            table.add(musicLabel).uniform().align(Align.left).padLeft(20);
            table.add(music).uniform().spaceBottom(5).align(Align.left);
            table.row().expand();
            table.add(volumeLabel).uniform().align(Align.left).padLeft(20);
            table.add(volume).uniform().align(Align.left);
            table.row().expand();
            table.add(back).uniform().left().spaceTop(25).pad(5);
            table.add(apply).uniform().right().spaceTop(25).pad(5);
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

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
            super.dispose();

    }

}