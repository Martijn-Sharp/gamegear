package com.gamegear.firstwing.screens;

import java.util.Locale;

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
            
            //Graphics

//            final Label resolutionLabel = new Label("Resolution: " + game.getPrefs().getWidth() + " x " + game.getPrefs().getHeight(), getSkin());
//            final List resolution = new List(reso, getSkin());
//            resolution.setSize(300, 60);
//            for(int i = 0; i <= reso.length - 1; i++) {
//                    if(game.getPrefs().getWidth() == reso[i].width && game.getPrefs().getHeight() == reso[i].height) {
//                            resolution.setSelectedIndex(i);
//                    }
//            }
            
//            resolution.addListener(new ChangeListener() {
//                    @Override
//                    public void changed(ChangeEvent event, Actor actor) {
//                            int x = reso[resolution.getSelectedIndex()].width;
//                            int y = reso[resolution.getSelectedIndex()].height;
//                            game.getPrefs().setWidth(x);
//                            game.getPrefs().setHeight(y);
//                            resolutionLabel.setText("Resolution: "+ x + " x " + y);
//                    }
//            });
//            
//            final ScrollPane resScroll = new ScrollPane(resolution);
//            resScroll.setSmoothScrolling(true);
//            resScroll.setScrollbarsOnTop(true);
//
//            
//            final Label vSyncLabel = new Label("vSync: " + (game.getPrefs().vSyncEnabled() == true ? "on" : "off"), getSkin());
//            final CheckBox vSync = new CheckBox("", getSkin());
//            vSync.setChecked(game.getPrefs().vSyncEnabled());
//            vSync.addListener(new ChangeListener() {
//                    @Override
//                    public void changed(ChangeEvent event, Actor actor) {
//                            boolean t = vSync.isChecked();
//                            game.getPrefs().setVSync(t);
//                            vSyncLabel.setText("vSync: " + (game.getPrefs().vSyncEnabled() == true ? "on" : "off"));
//                    }
//            });
//
//            
//            final Label fullscreenLabel = new Label("Fullscreen: " + (game.getPrefs().getFullscreen() == true ? "yes" : "no"), getSkin());
//            final CheckBox fullscreen = new CheckBox("", getSkin());
//            fullscreen.setChecked(game.getPrefs().getFullscreen());
//            fullscreen.addListener(new ChangeListener() {
//                    @Override
//                    public void changed(ChangeEvent event, Actor actor) {
//                            boolean b = fullscreen.isChecked();
//                            game.getPrefs().setFullscreen(b);
//                            fullscreenLabel.setText("Fullscreen: " + (game.getPrefs().getFullscreen() == true ? "yes" : "no"));
//                    }
//            });
            
            //Controls
            final Label invertLabel = new Label("Invert Controls: " + (FirstWing.options.invertEnabled() == true? "on" : "off") , getSkin());
            final CheckBox invert = new CheckBox("", getSkin());
            invert.setChecked(FirstWing.options.invertEnabled());
            invert.addListener(new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                            boolean b = invert.isChecked();
                            FirstWing.options.setInvert(b);
                            invertLabel.setText("Invert Controls: " + (FirstWing.options.invertEnabled() == true? "on" : "off"));
                    }
            });
            
            
            final Label sensLabel = new Label("Sensitivity: " + String.format(Locale.US, "%1.0f%%", FirstWing.options.getSensitivity() * 100), getSkin());
            final Slider sensitivity = new Slider( 0f, 1f, 0.01f, false, getSkin(), "default-horizontal");
            sensitivity.setValue(FirstWing.options.getSensitivity());
            sensitivity.addListener(new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                    			FirstWing.options.setSensitivity(sensitivity.getValue());
                    			sensLabel.setText("Sensitivity: " + String.format(Locale.US, "%1.0f%%", sensitivity.getValue() * 100));
                            }
                    });
            

            
            //Audio
            final Label musicLabel = new Label("Music: " + (FirstWing.options.musicEnabled() == true? "on" : "off") , getSkin());
            final CheckBox music = new CheckBox("", getSkin());
            music.setChecked(FirstWing.options.musicEnabled());
            music.addListener(new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                            boolean b = music.isChecked();
                            FirstWing.options.setMusicEnabled(b);
                            musicLabel.setText("Music: " + (FirstWing.options.musicEnabled() == true? "on" : "off"));
                    }
            });
            
            
            final Label volumeLabel = new Label("Volume: " + String.format(Locale.US, "%1.0f%%", FirstWing.options.getVolume() * 100), getSkin());
            final Slider volume = new Slider( 0f, 1f, 0.01f, false, getSkin(), "default-horizontal");
            volume.setValue(FirstWing.options.getVolume());
            volume.addListener(new ChangeListener() {
                    @Override
                    public void changed(ChangeEvent event, Actor actor) {
                    			FirstWing.options.setVolume(volume.getValue());
                    			volumeLabel.setText("Volume: " + String.format(Locale.US, "%1.0f%%", volume.getValue() * 100));
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
            table.row();
            table.add(invertLabel);
            table.add(invert).uniform().spaceBottom(5);
            table.row();
            table.add(sensLabel);
            table.add(sensitivity).uniform();
            table.row();
            
            //Add audio to table
            table.add("Audio").spaceBottom(15.0f).colspan(2).align(Align.left);
            table.row();
            table.add(musicLabel);
            table.add(music).uniform().spaceBottom(5);
            table.row();
            table.add(volumeLabel);
            table.add(volume).uniform();
            table.row();
            table.add(back).size(300, 60).left().spaceTop(25).pad(5);
            table.add(apply).size(300, 60).right().spaceTop(25).pad(5);
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