package com.badlogic.poker.core.mvc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.poker.core.PokerGame;

import static com.badlogic.poker.core.Utils.getRGBColor;

/**
 * Created by Aleksey_Zverkov on 7/1/2015.
 */
public class MainScreen extends MyScreen {

    GameScreenListener listener;

    public MainScreen(PokerGame game) {
        super(game);
        initScreen();
        Gdx.input.setInputProcessor(new GameScreenListener(game.controller, stage));
    }

    @Override
    public void render(float delta) {
        Color bgColor = getRGBColor(0, 255, 255);
        Gdx.gl.glClearColor(bgColor.r, bgColor.g, bgColor.b, bgColor.a);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

//        if (Gdx.input.isTouched()){
//            game.setScreen(new StartScreen(game));
//        }

    }

    private void initScreen() {
        Group tableGroup = new Group();
        Group background = new Group();
        stage.addActor(background);
        stage.addActor(tableGroup);

        System.out.println("Main Screen: Actors added");
    }

}
