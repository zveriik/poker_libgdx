package com.badlogic.poker.core.mvc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.poker.core.PokerGame;
import com.badlogic.poker.core.mvc.GameScreenListener;
import com.badlogic.poker.core.mvc.MyScreen;

/**
 * Created by Aleksey_Zverkov on 7/6/2015.
 */
public class EndScreen extends MyScreen {

    public EndScreen(PokerGame game) {
        super(game);
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        game.batch.begin();
        String gameOver = "GAME OVER!";
        BitmapFont.TextBounds bounds = game.font.getBounds(gameOver);
        game.font.draw(game.batch, gameOver,
                Gdx.graphics.getWidth()/2 - bounds.width/2,
                Gdx.graphics.getHeight()/2 - bounds.height/2);
        game.batch.end();

    }
}
