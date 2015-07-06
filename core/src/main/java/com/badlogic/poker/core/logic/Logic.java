package com.badlogic.poker.core.logic;

import com.badlogic.poker.core.entity.*;

import java.util.*;

/**
 * Created by Zveriki on 09.02.2015.
 */
public class Logic {

    private Game game;

    public Logic() {
        game = new Game(new Player(10, 1));
    }

    public Game getGame() {
        return game;
    }

    public void createDeck() {
        game.createDeck();
    }

    public void shuffleDeck() {
        game.shuffleDeck();
    }

    public void drawTable(){
        game.drawTable();
    }

    public void replaceCards(Set<Integer> holds){

        Card[] cards = game.getTable(Thread.currentThread().getStackTrace()[2].getMethodName()).getCardsOnDesk();
        for (Integer replace : holds) {
            game.getDeck().addLast(cards[replace]);
            cards[replace] = game.getDeck().removeFirst();
        }
        game.getTable(Thread.currentThread().getStackTrace()[2].getMethodName()).setCardsOnDesk(cards);
        game.shuffleDeck();

    }

    public WinCondition checkCombination() {
        Card[] cardsOnDesk = game.getTable(Thread.currentThread().getStackTrace()[2].getMethodName()).getCardsOnDesk();
        System.out.println("cards on table: " + cardsOnDesk.length);
        WinCondition win = checkForKind(cardsOnDesk);
        game.drawTable();
        game.changeMoney(win.getCost());
        return win;
    }

    public String getMoney(){
        return String.valueOf(game.getPlayer().getCash());
    }

    private WinCondition checkForFlushAndStraight(Card[] cards) {
        boolean flush = false;
        List<Card> checkList = Arrays.asList(cards);

        Collections.sort(checkList, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.getSuit().ordinal()>o2.getSuit().ordinal()?1:o1.getSuit().ordinal() <o2.getSuit().ordinal()?-1:0;
            }
        });

        if (checkList.get(0).getSuit() == checkList.get(4).getSuit()) flush = true;

        Collections.sort(checkList, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.getValue().ordinal()>o2.getValue().ordinal()?1:o1.getValue().ordinal() <o2.getValue().ordinal()?-1:0;
            }
        });

        if (checkList.get(4).getValue().ordinal() - checkList.get(0).getValue().ordinal() == 4)
            return flush ? checkList.get(4).getValue() == CardValue.ACE ? WinCondition.ROYAL_FLUSH : WinCondition.STRAIGHT_FLUSH : WinCondition.STRAIGHT;
        return flush?WinCondition.FLUSH:WinCondition.NONE;
    }

    private WinCondition checkForKind(Card[] cards) {

        Map<CardValue, Integer> index = new HashMap<CardValue, Integer>();

        for (Card card : cards) {
            Integer count = index.get(card.getValue());
            count = count == null ? 1 : count + 1;
            index.put(card.getValue(), count);
        }

        if (index.containsValue(4)) return WinCondition.FOUR_OF_KIND;
        if (index.containsValue(3) && index.size() == 3) return WinCondition.THREE_OF_KIND;
        if (index.containsValue(2)) {
            if (index.containsValue(3)) return WinCondition.FULL_HOUSE;
            if (index.size() == 3) return WinCondition.TWO_PAIR;
            return WinCondition.PAIR;
        }

        return checkForFlushAndStraight(cards);
    }

    public boolean checkEnoughMoney() {
        return game.getPlayer().getCash()<game.getPlayer().getBet();
    }
}
