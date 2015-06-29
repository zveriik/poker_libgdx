package com.badlogic.poker.core.mvc;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.poker.core.entity.Card;
import com.badlogic.poker.core.logic.Logic;
import com.badlogic.poker.core.logic.WinCondition;

import java.util.List;

public class Controller {

    private Logic logic = new Logic();

    public Image[] getTable() {
        if (logic.getGame().getTable().isEmpty()) logic.getGame().putCardOnTable();
        Card[] cards = logic.getGame().getTable().getCardsOnDesk();
        Image[] images = new Image[cards.length];
        for (int i = 0; i < cards.length; i++) {
            images[i] = new Image(cards[i].getTexture());
            System.out.println(cards[i].toString());
        }
        return images;
    }

    public void replaceCards(List holds) {
        logic.replaceCards(holds);
    }

    public Image checkWinCondition(){
        return logic.checkCombination().getImage();
    }

}
