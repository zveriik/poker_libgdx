package com.badlogic.poker.core.mvc;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.poker.core.entity.Card;
import com.badlogic.poker.core.logic.Logic;

public class Controller {

    private Logic logic = new Logic();

    public Image[] getTable() {
        Card[] cards = logic.getGame().getTable().getCardsOnDesk();
        Image[] images = new Image[cards.length];
        for (int i = 0; i < cards.length; i++) {
            images[i] = new Image(cards[i].getTexture());
        }
        return images;
    }

    public void chooseCard() {
        logic.chooseCard();
    }

    public void replaceCards() {
        logic.replaceCards();
    }

}
