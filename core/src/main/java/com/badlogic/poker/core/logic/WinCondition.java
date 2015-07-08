package com.badlogic.poker.core.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Zveriki on 09.02.2015.
 */
public enum WinCondition {
    NONE(-5, "cards/none.png"),
    PAIR(2, "cards/pair.png"),
    TWO_PAIR(3, "cards/two_pair.png"),
    THREE_OF_KIND(5, "cards/three_of_kind.png"),
    STRAIGHT(15, "cards/straight.png"),
    FLUSH(25, "cards/flush.png"),
    FULL_HOUSE(50, "cards/full_house.png"),
    FOUR_OF_KIND(200, "cards/four_of_kind.png"),
    STRAIGHT_FLUSH(500, "cards/street_flush.png"),
    ROYAL_FLUSH(1000, "cards/royal_flush.png");

    private int cost;
    private String pathFile;

    WinCondition(int cost, String pathFile) {
        this.cost = cost;
        this.pathFile = pathFile;
    }

    public int getCost() {
        return cost;
    }

    public String getImage() {
        return pathFile;
    }
}
