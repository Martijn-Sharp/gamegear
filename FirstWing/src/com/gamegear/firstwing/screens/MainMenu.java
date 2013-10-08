package com.gamegear.firstwing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.gamegear.firstwing.FirstWing;

public class MainMenu extends MenuScreen{
    public MainMenu(FirstWing firstwing) {
        super(firstwing);
        load();
    }

    @Override
    public void show() {
        super.show();
        
        if(firstWing.platformInterface.getSignedIn())
        {
        	FirstWing.options.setPlayServices(true);
        }
        else
        {
        	FirstWing.options.setPlayServices(false);
        }
    }
    
    public void load()
    {
    	Table table = super.getTable();
        table.getColor().a = 0;
        table.addAction(Actions.fadeIn(0.5f));

        // Start
        TextButton newGameButton = new TextButton("Start Game", getSkin());
        newGameButton.addListener(new ClickListener() {
                public void clicked(InputEvent event, float x, float y) {
                	Gdx.app.log("Menu", "Clicked startgame");
                	//firstwing.setScreen(new GameScreen(firstwing, ""));
                	firstWing.setScreen(firstWing.extLevelScreen);
                }
        });
        
        // Help
        TextButton helpButton = new TextButton("Help", getSkin());
        helpButton.addListener(new ClickListener() {
                public void clicked(InputEvent event, float x, float y) {
                	Gdx.app.log("Menu", "Clicked help");
                	//firstWing.setScreen(new UpgradeScreen(firstWing));
                	firstWing.setScreen(new HelpScreen(firstWing, -1));
                }
        });
        
        // Upgrades
//        TextButton upgradeButton = new TextButton("Upgrade", getSkin());
//        upgradeButton.addListener(new ClickListener() {
//                public void clicked(InputEvent event, float x, float y) {
//                	Gdx.app.log("Menu", "Clicked upgrade");
//                	firstWing.setScreen(firstWing.upgradeScreen);
//                }
//        });
        
        // Leaderboards
		TextButton leaderButton = new TextButton("Leaderboard", getSkin());
		leaderButton.addListener(new ClickListener() {
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.log("Menu", "Clicked leaderboards");
				if(!FirstWing.options.getPlayServices())
				{
					firstWing.platformInterface.Login();
					FirstWing.options.setPlayServices(true);
				}
				else
				{
					firstWing.platformInterface.getLeaderboard();
				}
			}
		});

        // Options
        TextButton optionsButton = new TextButton("Options", getSkin());
        optionsButton.addListener(new ClickListener() {
                public void clicked(InputEvent event, float x, float y) {
                	Gdx.app.log("Menu", "Clicked menu");
                	firstWing.setScreen(firstWing.optionsScreen);
                }
        });

        // Exit
        TextButton exitButton = new TextButton("Exit", getSkin());
        exitButton.addListener(new ClickListener() {
                public void clicked(InputEvent event, float x, float y) {
                        Gdx.app.exit();
                }
        });

        // Layout
        table.add("Fullcolor Express").spaceBottom(15.0f);
        table.row();
        table.add(newGameButton).fill().uniform().spaceBottom(10);
        table.row();
        table.add(helpButton).fill().uniform().spaceBottom(10);
        table.row();
//        table.add(upgradeButton).fill().uniform().spaceBottom(10);
//        table.row();
        table.add(leaderButton).fill().uniform().spaceBottom(10);
        table.row();
        table.add(optionsButton).fill().uniform().spaceBottom(10);
        table.row();
        table.add(exitButton).fill().uniform().spaceBottom(10);
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
}