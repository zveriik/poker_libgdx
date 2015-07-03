package com.badlogic.poker.core.mvc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.poker.core.PokerGame;

/**
 * Created by Aleksey_Zverkov on 7/3/2015.
 */
public abstract class MyScreen implements Screen{

    PokerGame game;
    OrthographicCamera camera;

    public MyScreen(PokerGame game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 400);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
//        game.batch.setProjectionMatrix(camera.combined);
    }
}
