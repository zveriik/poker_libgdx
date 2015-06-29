package com.badlogic.poker.core.mvc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.poker.core.entity.Card;

/**
 * Created by Aleksey_Zverkov on 6/26/2015.
 */
public class TableListener implements InputProcessor {

    Controller controller;
    Stage stage;

    public TableListener(Controller controller, Stage stage) {
        this.controller = controller;
        this.stage = stage;
    }

    @Override
    public boolean keyDown(int i) {

        Group table = (Group) stage.getActors().first();
        Actor frame = table.findActor("frame");
        int count = (int) (frame.getX() - 30) / 90;
        Actor card = table.findActor("" + count);
        boolean isHold = isHold(card);

        if (i == Input.Keys.RIGHT && frame.getX() < 390) {
            frame.setPosition(frame.getX() + 90, frame.getY());
        }
        if (i == Input.Keys.LEFT && frame.getX() > 90) {
            frame.setPosition(frame.getX() - 90, frame.getY());
        }
        if (i == Input.Keys.UP && !isHold) {
            card.setPosition(card.getX(), card.getY() + 30);
        }
        if (i == Input.Keys.DOWN && isHold) {
            System.out.println(isHold);
            card.setPosition(card.getX(), card.getY() - 30);
        }

        return false;
    }

    @Override
    public boolean keyUp(int i) {

        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i1, int i2, int i3) {

        Group group = (Group) stage.getActors().first();
        Actor hitActor = group.hit(i, i1, false);
        if (hitActor != null) {
            int y = isHold(hitActor) ? -1 : 1;
            hitActor.setPosition(hitActor.getX(), hitActor.getY() + y*30);
        }
        return false;
    }

    @Override
    public boolean touchUp(int i, int i1, int i2, int i3) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i1, int i2) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i1) {
        Group group = (Group) stage.getActors().first();
        Actor cardBox = group.findActor("frame");
        int x = i / 90 > 4 ? 4 : i / 90;
        cardBox.setPosition(30 + 90 * (x), cardBox.getY());
        return false;
    }

    @Override
    public boolean scrolled(int i) {
        return false;
    }

    private boolean isHold(Actor actor) {
        System.out.println(actor.getY());
        return actor.getY() > 90;
    }
}
