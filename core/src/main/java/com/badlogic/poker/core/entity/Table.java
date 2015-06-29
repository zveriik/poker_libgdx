package com.badlogic.poker.core.entity;

/**
 * Created by Zveriki on 09.02.2015.
 */
public class Table {

    private final Card[] cardsOnDesk = new Card[5];
    private boolean isEmpty = true;

    public Table() {
    }

    public Card[] getCardsOnDesk() {
        return cardsOnDesk;
    }

    public void setCardsOnDesk(Card[] cards){
        isEmpty = false;
        if (cards.length == cardsOnDesk.length) {
            for (int i = 0; i <cardsOnDesk.length; i++){
                cardsOnDesk[i] = cards[i];
            }
        }
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("cardsOnDesk: \n");
        for (int i = 0; i < cardsOnDesk.length; i++) {
            str.append("(").append(i + 1).append(") ").append(cardsOnDesk[i].toString()).append("\n");
        }
        return str.toString();
    }
}

