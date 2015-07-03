package com.badlogic.poker.core.mvc;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.poker.core.PokerGame;


import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aleksey_Zverkov on 6/26/2015.
 */
public class TableListener implements InputProcessor {

    Controller controller;
    Stage stage;
    Set<Integer> holds = new HashSet<Integer>();

    boolean start = true;
    boolean firstTable = true;
    boolean waitNewGame = false;
    int count = 0;

    public TableListener(Controller controller, Stage stage) {
        this.controller = controller;
        this.stage = stage;
    }

    @Override
    public boolean keyDown(int i) {

        Group table = (Group) stage.getActors().first();
        if (start) {
            start = false;

            Image[] tableTable = controller.startNewGame();
            for (int j = 0; j < tableTable.length; j++) {
                Image img = tableTable[j];
                img.setName("" + j);
                img.setPosition(30 + 90 * j, 90);
                table.addActor(img);
            }
        } else {
            Actor card = table.findActor("" + count);
            boolean isHold = isHold(card);

            if (firstTable && !start) {
                if (i == Input.Keys.RIGHT && count < 4) {
                    table.findActor("" + count).setScale(1f);
                    count++;
                    table.findActor("" + count).setScale(1.075f);
                }
                if (i == Input.Keys.LEFT && count > 0) {
                    table.findActor("" + count).setScale(1f);
                    count--;
                    table.findActor("" + count).setScale(1.075f);
                }
                if (i == Input.Keys.UP && !isHold) {
                    card.setPosition(card.getX(), card.getY() + 30);
                    holds.add(count);
                }
                if (i == Input.Keys.DOWN && isHold) {
                    card.setPosition(card.getX(), card.getY() - 30);
                    holds.remove(count);
                }
            }
            if (i == Input.Keys.SPACE || i == Input.Keys.ENTER) {
                if (!firstTable) {
                    if (waitNewGame) {
                        //start new game

                        startNewGame(table);
                        firstTable = true;
                        waitNewGame = false;
                    } else {
                        waitNewGame = true;
                        //check win and draw

                        Image winCondition = controller.checkWinCondition();
                        winCondition.setPosition((PokerGame.WINDOW_WIDTH - winCondition.getWidth()) / 2, (PokerGame.WINDOW_HEIGHT - winCondition.getHeight()) / 2);
                        table.clear();
                        table.addActor(winCondition);
                        holds.clear();
                    }
                } else {
                    // redraw HOLDS cards

                    firstTable = false;
                    waitNewGame = false;

                    table.clear();

                    controller.replaceCards(holds);
                    holds.clear();

                    Image[] tableCardImages = controller.getTableCardImages();
                    for (int place = 0; place < tableCardImages.length; place++) {
                        Image img = tableCardImages[place];
                        img.setName("" + place);
                        img.setPosition(30 + 90 * place, 90);
                        table.addActor(img);
                    }
                }
            }
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

        if (start) { //first launch
            start = false;

            Image[] tableTable = controller.startNewGame();
            for (int j = 0; j < tableTable.length; j++) {
                Image img = tableTable[j];
                img.setName("" + j);
                img.setPosition(30 + 90 * j, 90);
                group.addActor(img);
            }
        } else {

            Actor hitActor = group.hit(i, i1, false);
            if (!firstTable) {
                if (waitNewGame) {
                    //start new game

                    startNewGame(group);
                    firstTable = true;
                    waitNewGame = false;
                } else {
                    waitNewGame = true;
                    //check win and draw

                    Image winCondition = controller.checkWinCondition();
                    winCondition.setPosition((PokerGame.WINDOW_WIDTH - winCondition.getWidth()) / 2, (PokerGame.WINDOW_HEIGHT - winCondition.getHeight()) / 2);
                    group.clear();
                    group.addActor(winCondition);

                    holds.clear();
                }
            } else {
                if (hitActor != null) {   //hit card for hold
                    int y = isHold(hitActor) ? -1 : 1;
                    hitActor.setPosition(hitActor.getX(), hitActor.getY() + y * 30);
                    count = (int) (hitActor.getX() - 30) / 90;
                    if (!isHold(hitActor))
                        holds.remove(count);
                    else
                        holds.add(count);

                } else {
                    // redraw HOLDS cards

                    firstTable = false;
                    waitNewGame = false;

                    group.clear();
                    controller.replaceCards(holds);
                    holds.clear();

                    Image[] table = controller.getTableCardImages();
                    for (int place = 0; place < table.length; place++) {
                        Image img = table[place];
                        img.setName("" + place);
                        img.setPosition(30 + 90 * place, 90);
                        group.addActor(img);
                    }
                }
            }
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
        if (firstTable && !start) {
            Group group = (Group) stage.getActors().first();
            int currentPoint = i / 90 > 4 ? 4 : i / 90;
            if (count != currentPoint) {
                group.findActor("" + count).setScale(1f);
                group.findActor("" + currentPoint).setScale(1.075f);
                count = currentPoint;
            }
        }
        return false;
    }

    @Override
    public boolean scrolled(int i) {
        return false;
    }

    private boolean isHold(Actor actor) {
        return actor.getY() > 90;
    }

    private void startNewGame(Group group) {
        group.clear();
        Image[] images = controller.startNewGame();
        for (int i = 0; i < images.length; i++) {
            Image img = images[i];
            img.setName("" + i);
            img.setPosition(30 + 90 * i, 90);
            group.addActor(img);
        }
    }

}
