package com.badlogic.poker.core.mvc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.poker.core.PokerGame;
import com.badlogic.poker.core.PokerStage;
import com.badlogic.poker.core.Utils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aleksey_Zverkov on 6/26/2015.
 */
public class GameScreenListener implements InputProcessor {

    Controller controller;
    PokerStage stage;
    Set<Integer> holds = new HashSet<Integer>();

    boolean firstTable = true;
    boolean waitNewGame = false;
    int count = 0;

    public GameScreenListener(Controller controller, PokerStage stage) {
        this.controller = controller;
        this.stage = stage;
    }

    @Override
    public boolean keyDown(int i) {

        Group table = (Group) stage.getActors().peek();

        Actor card = table.findActor("" + count);
        boolean isHold = isHold(card);

        if (firstTable) {
            if (i == Input.Keys.RIGHT && count < 4) {
                scaleCard(table, count, false);
                count++;
                scaleCard(table, count, true);
            }
            if (i == Input.Keys.LEFT && count > 0) {
                scaleCard(table, count, false);
                count--;
                scaleCard(table, count, true);
            }
            if (i == Input.Keys.UP && !isHold) {
                card.setPosition(card.getX(), card.getY() + Utils.HOLDS_UP);
                holds.add(count);
            }
            if (i == Input.Keys.DOWN && isHold) {
                card.setPosition(card.getX(), card.getY() - Utils.HOLDS_UP);
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
                    img.setPosition(Utils.INIT_X + Utils.X_STEP  * place, Utils.INIT_Y);
                    table.addActor(img);
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

        Vector2 coord = stage.screenToStageCoordinates(new Vector2(i, i1));

        Group group = (Group) stage.getActors().peek();
        Actor hitActor = group.hit(coord.x, coord.y, false);

        System.out.println("Mouse Hit X,Y: " + i + ", "+i1);

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
                winCondition.setPosition(Gdx.graphics.getWidth()/2 - winCondition.getWidth() / 2, Gdx.graphics.getWidth()/2 - winCondition.getHeight() / 2);
                group.clear();
                group.addActor(winCondition);

                holds.clear();
            }
        } else {
            if (hitActor != null) {   //hit card for hold
                System.out.println("Hit X,Y: " + hitActor.getX() + ", "+hitActor.getY());
                int y = isHold(hitActor) ? -1 : 1;
                hitActor.setPosition(hitActor.getX(), hitActor.getY() + y * Utils.HOLDS_UP);
                count = (int) (hitActor.getX() - Utils.INIT_X) / Utils.INIT_Y;
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
                    img.setPosition(Utils.INIT_X + Utils.X_STEP  * place, Utils.INIT_Y);
                    group.addActor(img);
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
        if (firstTable) {
            Group group = (Group) stage.getActors().peek();
            int currentPoint = i / Utils.X_STEP  > 4 ? 4 : i / Utils.X_STEP ;
            if (count != currentPoint) {
                scaleCard(group, count, false);
                scaleCard(group, currentPoint, true);
                count = currentPoint;
            }
        }
        return false;
    }

    @Override
    public boolean scrolled(int i) {
        return false;
    }

    private void scaleCard(Group table,  int count, boolean select) {
        Actor actor = table.findActor("" + count);
        actor.setScale(select?1.08f:1f);
        System.out.println("X: " + actor.getX() + ", Y: " + actor.getY());
    }

    private boolean isHold(Actor actor) {
        return actor.getY() > Utils.INIT_Y;
    }

    private void startNewGame(Group group) {
        group.clear();
        Image[] images = controller.startNewGame();
        for (int i = 0; i < images.length; i++) {
            Image img = images[i];
            img.setName("" + i);
            img.setPosition(Utils.INIT_X + Utils.X_STEP  * i, Utils.INIT_Y);
            group.addActor(img);
        }
    }

}
