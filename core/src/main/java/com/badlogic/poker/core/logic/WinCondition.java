package com.badlogic.poker.core.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Zveriki on 09.02.2015.
 */
public enum WinCondition {
    NONE(-1, new Image(new Texture(Gdx.files.internal("cards/3.png")))),
    PAIR(2, new Image(new Texture(Gdx.files.internal("cards/3.png")))),
    TWO_PAIR(3, new Image(new Texture(Gdx.files.internal("cards/3.png")))),
    THREE_OF_KIND(5, new Image(new Texture(Gdx.files.internal("cards/3.png")))),
    STRAIGHT(15, new Image(new Texture(Gdx.files.internal("cards/3.png")))),
    FLUSH(25, new Image(new Texture(Gdx.files.internal("cards/3.png")))),
    FULL_HOUSE(50, new Image(new Texture(Gdx.files.internal("cards/3.png")))),
    FOUR_OF_KIND(200, new Image(new Texture(Gdx.files.internal("cards/3.png")))),
    STRAIGHT_FLUSH(500, new Image(new Texture(Gdx.files.internal("cards/3.png")))),
    ROYAL_FLUSH(1000, new Image(new Texture(Gdx.files.internal("cards/3.png"))));

    private int cost;
    private Image image;

    WinCondition(int cost, Image image) {
        this.cost = cost;
        this.image = image;
    }

    public int getCost() {
        return cost;
    }

    public Image getImage() {
        return image;
    }
}
