package com.badlogic.poker.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.badlogic.poker.core.Utils.getRGBColor;

/**
 * Created by Aleksey_Zverkov on 6/18/2015.
 */
public class PokerScreen implements Screen {

    PokerStage stage;
    float elapsed;

    @Override
    public void show() {
        stage = new PokerStage();
        stage.init();
    }

    @Override
    public void render(float delta) {
        elapsed += Gdx.graphics.getDeltaTime();

        Color bgColor = getRGBColor(50, 255, 80);
        Gdx.gl.glClearColor(bgColor.r, bgColor.g, bgColor.b, bgColor.a);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);

    }

    private void drawTableCards(float delta) {
/*        for (SpriteBatch batch:stage.tableCardsSprites) {
            batch.begin();
            System.out.println(delta);
            batch.draw(stage.texture, 100 + 100 * (float) Math.cos(elapsed), 100 + 25 * (float) Math.sin(elapsed));
            batch.end();
        }*/
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

    }
}
