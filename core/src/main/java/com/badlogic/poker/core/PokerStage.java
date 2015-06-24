package com.badlogic.poker.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


/**
 * Created by Aleksey_Zverkov on 6/18/2015.
 */
public class PokerStage extends Stage {

    Texture texture;
    SpriteBatch[] tableCardsSprites = new SpriteBatch[5];

    public PokerStage() {
        setViewport(new ScreenViewport());
    }

    public void init() {
        texture = new Texture(Gdx.files.internal("libgdx-logo.png"));
        for (int i = 0; i < 5; i++) {
            tableCardsSprites[i] = new SpriteBatch();
            System.out.println("Sprite " + i + " init");
        }
    }

    @Override
    public void draw() {
        super.draw();
    }
}
