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

        Group group = new Group();
        this.addActor(group);
        CardBox[] sprites = new CardBox[5];

        for (int i=0; i<5; i++) {
//			frames[i] = frame;
//			frames[i].setPosition(10+i*90, 50);
//			group.addActor(frames[i]);
            sprites[i] = new CardBox(30+i*90, 90, new Texture(Gdx.files.internal("cards/frame.png")));
            group.addActor(sprites[i]);

        }
    }

    @Override
    public void draw() {
        super.draw();
    }
}
