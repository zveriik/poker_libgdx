package com.badlogic.poker.core.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.LinkedList;

/**
 * Created by Zveriki on 09.02.2015.
 */
public class Game {

    private Player player;
    private Deck deck = createDeck();
    private Table table = new Table();

    public Game() {
    }

    public Game(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Deck getDeck() {
        return deck;
    }

    public Deck createDeck() {
        int count = 1;
        LinkedList<Card> deck = new LinkedList<Card>();
        for (CardSuit suit : CardSuit.values()) {
            for (CardValue value : CardValue.values()) {
                deck.add(new Card(suit, value, new Texture(Gdx.files.internal("libgdx-logo.png"))));
            }
        }
        return new Deck(deck);
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
