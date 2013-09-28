package com.gamegear.firstwing;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gamegear.firstwing.screens.GameScreen;

public class Splash implements Screen
{
        private SpriteBatch spriteBatch;
        private Texture splash;
        private Game game;
        
        /**
         * Constructor for the splash screen
         * @param g Game which called this splash screen.
         */
        public Splash(Game g)
        {
                game = g;
        }

        @Override
        public void render(float delta)
        {
                Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
                spriteBatch.begin();
                spriteBatch.draw(splash, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                spriteBatch.end();
                
                if(Gdx.input.justTouched())
                        game.setScreen(new GameScreen());
        }
        
        @Override
        public void show()
        {
                spriteBatch = new SpriteBatch();
                Texture.setEnforcePotImages(false);
                splash = new Texture(Gdx.files.internal("images/menu/splash.png"));
                
        }

		@Override
		public void resize(int width, int height) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void hide() {
			// TODO Auto-generated method stub
			
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
			spriteBatch.dispose();
			splash.dispose();
		}
}