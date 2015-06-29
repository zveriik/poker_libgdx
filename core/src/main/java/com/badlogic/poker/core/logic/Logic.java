package com.badlogic.poker.core.logic;

import com.badlogic.poker.core.entity.*;

import java.util.*;

/**
 * Created by Zveriki on 09.02.2015.
 */
public class Logic {

    private Game game = new Game();

    public Logic() {
        createDeck();
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

    public WinCondition replaceCards(List<Integer> holds){
        WinCondition winCondition = checkCombination();
        Card[] cards = game.getTable().getCardsOnDesk();
        for (Integer replace:holds){
            cards[replace] = game.getDeck().removeFirst();
        }
        game.getTable().setCardsOnDesk(cards);
        game.createDeck();
        return winCondition;
    }

    public WinCondition checkCombination() {
        Card[] cardsOnDesk = game.getTable().getCardsOnDesk();
        WinCondition win = checkForKind(cardsOnDesk);
        return win;
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

}
