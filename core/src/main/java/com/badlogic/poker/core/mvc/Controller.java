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
        if (logic.getGame().getTable().isEmpty())
            logic.getGame().putCardOnTable();

        Card[] cards = logic.getGame().getTable().getCardsOnDesk();
        Image[] images = new Image[cards.length];
        for (int i = 0; i < cards.length; i++) {
            Texture texture = new Texture(cards[i].getTexture());
            texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            Image img = new Image(texture);
            img.setOrigin(img.getCenterX(), img.getCenterY());
            images[i] = img;
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

    public String getMoney() {
        return logic.getMoney();
    }

    public boolean checkEnoughMoney() {
        return logic.checkEnoughMoney();
    }
}
