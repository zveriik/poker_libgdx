package com.badlogic.poker.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.poker.core.entity.Card;
import com.badlogic.poker.core.mvc.*;


/**
 * Created by Aleksey_Zverkov on 6/18/2015.
 */
public class PokerStage extends Stage {

    public PokerStage() {
        setViewport(new ScreenViewport());
        System.out.println("Create Stage");
    }

    public void init() {

        System.out.println("Init Stage");
    }

    @Override
    public void draw() {
        super.draw();
    }
}
