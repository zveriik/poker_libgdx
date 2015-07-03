package com.badlogic.poker.core.mvc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.poker.core.PokerGame;
import com.badlogic.poker.core.PokerStage;

import static com.badlogic.poker.core.Utils.getRGBColor;

/**
 * Created by Aleksey_Zverkov on 7/1/2015.
 */
public class MainScreen implements Screen {

    PokerGame game;
    PokerStage stage;
    TableListener tableListener;

    public MainScreen(PokerGame game) {
        this.game = game;
        Gdx.input.setInputProcessor(tableListener);
    }

    @Override
    public void render(float delta) {
        Color bgColor = getRGBColor(0, 255, 255);
        Gdx.gl.glClearColor(bgColor.r, bgColor.g, bgColor.b, bgColor.a);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        stage.draw();
        if (Gdx.input.isTouched()){
            game.setScreen(game.startScreen);
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void show() {

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

    }
}
