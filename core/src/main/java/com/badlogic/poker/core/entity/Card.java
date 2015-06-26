package com.badlogic.poker.core.entity;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Zveriki on 09.02.2015.
 */
public class Card {

    private CardSuit suit;

    private CardValue value;

    private boolean faceUp;

    private Texture texture;

    public Card() {
    }

    public Card(CardSuit suit, CardValue value, Texture texture) {
        this.suit = suit;
        this.value = value;
        this.faceUp = false;
        this.texture = texture;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public void setSuit(CardSuit suit) {
        this.suit = suit;
    }

    public CardValue getValue() {
        return value;
    }

    public void setValue(CardValue value) {
        this.value = value;
    }

    public boolean isFaceUp() {
        return faceUp;
    }

    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    @Override
    public String toString() {
        return "Card[suit=" + suit + ", value=" + value + "]";
    }

}