package com.badlogic.poker.core.mvc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.poker.core.PokerGame;
import com.badlogic.poker.core.PokerStage;
import com.badlogic.poker.core.entity.Table;

import static com.badlogic.poker.core.Utils.getRGBColor;

/**
 * Created by Aleksey_Zverkov on 6/18/2015.
 */
public class StartScreen implements Screen {

    final PokerGame game;
    PokerStage stage;

    Table table = new Table();

    public StartScreen(PokerGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        stage = new PokerStage();
        stage.init();
    }

    @Override
    public void render(float delta) {
        Color bgColor = getRGBColor(255, 255, 80);
        Gdx.gl.glClearColor(bgColor.r, bgColor.g, bgColor.b, bgColor.a);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
