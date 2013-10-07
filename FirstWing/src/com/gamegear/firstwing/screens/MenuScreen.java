package com.gamegear.firstwing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.List.ListStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.gamegear.firstwing.FirstWing;

public abstract class MenuScreen implements Screen {

    protected Stage stage;
    protected FirstWing firstWing;

    private Table table;
    private Skin skin;
    private FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal("ui/TiresiasScreenfont.ttf"));
    protected BitmapFont font;
    private NinePatchDrawable background;
    
    //Styles
    LabelStyle labelStyle;
    TextButtonStyle buttonStyle;
    ListStyle listStyle;

    public MenuScreen(FirstWing firstWing) {
        this.firstWing = firstWing;
        stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
        
        int adjustedFontSize = (int)(26 * (Gdx.graphics.getDensity()));
        font = gen.generateFont(adjustedFontSize);
        
        this.getSkin();
        
        labelStyle = skin.get("default", LabelStyle.class);
        labelStyle.font = font;
        
        buttonStyle = skin.get("default", TextButtonStyle.class);
        buttonStyle.font = font;
        
        listStyle = skin.get("default", ListStyle.class);
        listStyle.font = font;
        
        background = new NinePatchDrawable(new NinePatch(new Texture(Gdx.files.internal("images/menu/start-empty.png"))));
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        stage.act(delta);

        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.setViewport(width, height, true);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    	stage.dispose();
    }

    protected Table getTable() {
        if (table == null) {
                table = new Table(getSkin());
                table.setBackground(background);
                table.setFillParent(true);
                stage.addActor(table);
        }
        return table;
    }

    protected Skin getSkin() {
        if (skin == null) {
                FirstWing.manager.load("ui/uiskin.json", Skin.class);
                FirstWing.manager.finishLoading();
                skin = FirstWing.manager.get("ui/uiskin.json");
                skin.add("top", skin.newDrawable("default-round", Color.BLUE), Drawable.class);
                skin.add("button-disabled", skin.newDrawable("default-round", Color.DARK_GRAY), Drawable.class);
                skin.add("star-filled", skin.newDrawable("white", Color.YELLOW), Drawable.class);
                skin.add("star-unfilled", skin.newDrawable("white", Color.GRAY), Drawable.class);
        }
        return skin;
    }

    public FirstWing getGame() {
        return this.firstWing;
    }
}