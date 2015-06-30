package com.badlogic.poker.core.mvc;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.poker.core.entity.Card;
import com.badlogic.poker.core.logic.Logic;

import java.util.Set;

public class Controller {

    private Logic logic = new Logic();

    public Image[] getTableCardImages() {
        if (logic.getGame().getTable(Thread.currentThread().getStackTrace()[2].getMethodName()).isEmpty())
            logic.getGame().putCardOnTable();

        Card[] cards = logic.getGame().getTable(Thread.currentThread().getStackTrace()[2].getMethodName()).getCardsOnDesk();
        Image[] images = new Image[cards.length];
        for (int i = 0; i < cards.length; i++) {
            images[i] = new Image(cards[i].getTexture());
        }
        return images;
    }


    public void replaceCards(Set holds) {
        logic.replaceCards(holds);
    }

    public Image checkWinCondition(){
        return new Image(new Texture(Gdx.files.internal(logic.checkCombination().getImage())));
    }

    public Image[] startNewGame(){
        System.out.println(logic.getGame().getDeck().getDeck().size());
        logic.drawTable();
        return getTableCardImages();
    }



}
