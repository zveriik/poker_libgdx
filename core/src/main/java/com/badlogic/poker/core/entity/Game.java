package com.badlogic.poker.core.entity;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Aleksey_Zverkov on 6/29/2015.
 */
public class Game {

    private Player player;
    private Deck deck = createDeck();
    private Table table = new Table();

    public Game(Player player) {
        this.player = player;
        shuffleDeck();
    }

    public Game() {
        shuffleDeck();
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

    public Table getTable() {
        putCardOnTable();
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public Deck createDeck() {
        LinkedList<Card> deck = new LinkedList<Card>();
        for (CardSuit suit : CardSuit.values()) {
            for (CardValue value : CardValue.values()) {
                deck.add(new Card(suit, value));
            }
        }
        return new Deck(deck);
    }

    public void shuffleDeck() {
        LinkedList<Card> cards = deck.getDeck();
        Collections.shuffle(cards, new Random(System.nanoTime()));
        deck.setDeck(cards);
    }

    private void putCardOnTable(){
        Card[] cards = new Card[table.getCardsOnDesk().length];
        for (int i = 0; i < table.getCardsOnDesk().length; i++) {
            cards[i] = getDeck().removeFirst();
        }
        table.setCardsOnDesk(cards);
    }


}
