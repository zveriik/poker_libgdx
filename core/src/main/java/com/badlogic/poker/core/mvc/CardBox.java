package com.badlogic.poker.core.mvc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputListener;

/**
 * Created by Aleksey_Zverkov on 6/24/2015.
 */
public class CardBox extends Actor {

    private float initX = 0;
    private float initY = 0;
    public boolean drop = false;
    Texture texture = new Texture(Gdx.files.internal("cards/1.png"));

    public CardBox(int initX, int initY) {
        this.initX = initX;
        this.initY = initY;
    }

    @Override
    public boolean addListener(EventListener listener) {
        return super.addListener(new InputListener(){
            public boolean touchDown (InputListener event, float x, float y, int pointer, int button) {
                drop = true;
                System.out.println("Touch");
                return true;
            }
        });
    }

    public CardBox() {
    }

    public CardBox(Texture texture) {
        this.texture = texture;
    }

    public CardBox(float initX, float initY, Texture texture) {
        this.initX = initX;
        this.initY = initY;
        this.texture = texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, initX, initY);
    }
}
