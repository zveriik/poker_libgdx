package com.badlogic.poker.core.mvc;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.poker.core.PokerGame;


/**
 * Created by Aleksey_Zverkov on 6/18/2015.
 */
public class StartScreen extends MyScreen {

    public StartScreen(PokerGame game) {
        super(game);
        initScreen();
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        game.batch.begin();
        String text = "TAP\nTO START";
        BitmapFont.TextBounds bounds = game.font.getMultiLineBounds(text);
        game.font.drawMultiLine(game.batch, text, 30, Gdx.graphics.getHeight()/2 - bounds.height/2);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            dispose();
            game.setScreen(new MainScreen(game));
        }
    }

    private void initScreen(){
        Group background = new Group();
        stage.addActor(background);
        Image bg = new Image(new Texture(Gdx.files.internal("poker_start.jpg")));
        background.addActor(bg);

        System.out.println("Start Screen: Actors added");
    }
}
