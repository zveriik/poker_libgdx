package com.badlogic.poker.core.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

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
        putCardOnTable();
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

    public Table getTable(String method) {
        for(Card card:table.getCardsOnDesk()) {
            System.out.println("method: "+ method+" ----- "+card);
        }
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }


    public Deck createDeck() {
        int image = 1;
        LinkedList<Card> deck = new LinkedList<Card>();
        for (CardValue value : CardValue.values()) {
            for (CardSuit suit : CardSuit.values()) {
                deck.add(new Card(suit, value, new Texture(Gdx.files.internal("cards/" + image +".png"))));
                image++;
            }
        }
        return new Deck(deck);
    }

    public void shuffleDeck() {
        LinkedList<Card> cards = deck.getDeck();
        Collections.shuffle(cards, new Random(System.nanoTime()));
        deck.setDeck(cards);
    }

    public void putCardOnTable(){
        if(table.isEmpty()) {
            Card[] cards = new Card[table.getCardsOnDesk().length];
            for (int i = 0; i < table.getCardsOnDesk().length; i++) {
                cards[i] = getDeck().removeFirst();
            }
            table.setCardsOnDesk(cards);
            table.setIsEmpty(false);
        }
    }

    public void drawTable(){
        if (!table.isEmpty()) {
            Card[] tableCards = table.getCardsOnDesk();
            for(Card card:tableCards){
                deck.getDeck().add(card);
            }
            table.setIsEmpty(true);
            this.shuffleDeck();
        }
    }


}
