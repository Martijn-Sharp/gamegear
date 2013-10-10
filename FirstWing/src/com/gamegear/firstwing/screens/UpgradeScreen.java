package com.gamegear.firstwing.screens;

import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.gamegear.firstwing.FirstWing;
import com.gamegear.firstwing.levels.json.LevelProperties.ColorEnum;

public class UpgradeScreen extends MenuScreen{
	private FirstWing game;
    
    public UpgradeScreen(FirstWing game) {
            super(game);
            this.game = game;
            load();
    }

    @Override
    public void show() {
            super.show();
    }
    
    public void load()
    {
    	final LinkedList<String> colors = new LinkedList<String>();
        for(ColorEnum en : ColorEnum.values())
        {
        	if(en != ColorEnum.none)
        	{
        		colors.add(en.name());
        	}
        }
        
        
        final List upgradeColors = new List(colors.toArray(), getSkin());
        upgradeColors.setSize(300, 60);
        upgradeColors.setSelectedIndex(0);
        final Label upgradeLabel = new Label("Upgrade coins: " + FirstWing.stats.collectedOrbsColor.get(colors.get(upgradeColors.getSelectedIndex())), getSkin());
        
        upgradeColors.addListener(new ChangeListener() {
                @Override
                public void changed(ChangeEvent event, Actor actor) {
                        Gdx.app.log("Upgrade", "Selected " + colors.get(upgradeColors.getSelectedIndex()));
                        upgradeLabel.setText("Upgrade coins: " + FirstWing.stats.collectedOrbsColor.get(colors.get(upgradeColors.getSelectedIndex())));
                }
        });
        
        final ScrollPane upgradeScroll = new ScrollPane(upgradeColors);
        upgradeScroll.setSmoothScrolling(true);
        upgradeScroll.setScrollbarsOnTop(true);
        
        final Label upgradeWeaponLabel = new Label("Upgrade cost: 50", getSkin());
        TextButton upgradeWeaponButton = new TextButton("Buy Weapon", getSkin());
        upgradeWeaponButton.addListener(new ClickListener() {
              @Override
              public void clicked(InputEvent event, float x, float y) {
              	game.setScreen(new MainMenu(game));
              	
              }
        });
        
        final Label upgradeHealthLabel = new Label("Upgrade cost: 50", getSkin());
        TextButton upgradeHealthButton = new TextButton("Buy Health", getSkin());
        upgradeHealthButton.addListener(new ClickListener() {
              @Override
              public void clicked(InputEvent event, float x, float y) {
              	game.setScreen(new MainMenu(game));
              	
              }
        });

        Table table = super.getTable();
        table.getColor().a = 0;
        table.addAction(Actions.fadeIn(0.5f));
        
        //Add controls to table
        table.add("Upgrade Menu").spaceBottom(15.0f).colspan(2).align(Align.left);
        table.row();
        table.add(upgradeLabel).uniform().align(Align.left).padLeft(20).colspan(2);
        table.row();
        table.add(upgradeScroll).align(Align.left);
        table.row();
        table.add(upgradeWeaponButton).align(Align.left).fill();
        table.add(upgradeWeaponLabel).fill();
        table.row();
        table.add(upgradeHealthButton).align(Align.left).fill();
        table.add(upgradeHealthLabel).fill();
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

	@Override
	protected void handleReturn() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
