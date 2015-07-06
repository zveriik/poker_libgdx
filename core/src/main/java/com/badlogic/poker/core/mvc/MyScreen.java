package com.badlogic.poker.core.mvc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.poker.core.PokerGame;
import com.badlogic.poker.core.PokerStage;

/**
 * Created by Aleksey_Zverkov on 7/3/2015.
 */
public abstract class MyScreen implements Screen{

    PokerGame game;
    OrthographicCamera camera;
    PokerStage stage;

    public MyScreen(PokerGame game) {
        this.game = game;
        this.stage = game.stage;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 400);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 1f, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.stage.act();
        game.stage.draw();

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
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
        stage.clear();
        System.out.println("Stage cleared");
    }
}
