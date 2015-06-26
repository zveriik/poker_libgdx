package com.badlogic.poker.core.mvc;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
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
        Group group = (Group)stage.getActors().first();
        Actor cardBox = group.findActor("frame");
        if(i == Input.Keys.RIGHT && cardBox.getX() < 390){
            cardBox.setPosition(cardBox.getX() + 90, cardBox.getY());
        }
        if(i == Input.Keys.LEFT && cardBox.getX() > 90){
            cardBox.setPosition(cardBox.getX() - 90, cardBox.getY());
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
        Vector2 coord = stage.screenToStageCoordinates(new Vector2((float) i, (float) i2));
        Actor hitActor = stage.hit(coord.x, coord.y, false);

        if(hitActor != null)
            System.out.println("HIT: " + hitActor.getName());
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
        Group group = (Group)stage.getActors().first();
        Actor cardBox = group.findActor("frame");
        cardBox.setPosition(30+90*(i/90), 90);
        return false;
    }

    @Override
    public boolean scrolled(int i) {
        return false;
    }
}
