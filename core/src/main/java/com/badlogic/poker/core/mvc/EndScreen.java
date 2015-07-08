package com.badlogic.poker.core.mvc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.poker.core.PokerGame;


/**
 * Created by Aleksey_Zverkov on 7/6/2015.
 */
public class EndScreen extends BaseScreen {

    public EndScreen(PokerGame game) {
        super(game);
        Gdx.input.setInputProcessor(null);
        initScreen();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        game.batch.begin();
        String gameOver = "GAME\nOVER";
        BitmapFont.TextBounds bounds = game.font.getMultiLineBounds(gameOver);
        game.font.drawMultiLine(game.batch, gameOver, 30, Gdx.graphics.getHeight() / 2 - bounds.height / 2);
        game.batch.end();

    }

    private void initScreen(){
        Group background = new Group();
        stage.addActor(background);
        Image bg = new Image(new Texture(Gdx.files.internal("poker_start.jpg")));
        background.addActor(bg);

        System.out.println("Start Screen: Actors added");
    }
}
