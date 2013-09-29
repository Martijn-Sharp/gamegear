package com.gamegear.firstwing.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gamegear.firstwing.FirstWing;

public class Splash implements Screen
{
        private SpriteBatch spriteBatch;
        private Texture splash;
        private FirstWing game;
        
        /**
         * Constructor for the splash screen
         * @param g Game which called this splash screen.
         */
        public Splash(FirstWing g)
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
                        game.setScreen(new MainMenu(game));
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